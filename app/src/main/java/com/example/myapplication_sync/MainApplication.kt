package com.example.myapplication_sync

import android.accounts.Account
import android.accounts.AccountManager
import android.app.Application
import android.content.ContentResolver
import android.content.Intent
import android.os.Bundle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import net.danlew.android.joda.JodaTimeAndroid

class MainApplication: Application() {
    companion object {
        const val AUTHORITY = "com.example.myapplication_sync.provider"
        const val ACCOUNT_TYPE = "com.example.myapplication_sync.account"
    }

    private val defaultSyncAccount = Account("Sync", ACCOUNT_TYPE)
    private val accountManager: AccountManager by lazy {
        AccountManager.get(this)
    }

    private val account: Account
        get() {
            createSyncAccountIfNecessary()
            return accountManager.getAccountsByType(ACCOUNT_TYPE)[0]
        }


    override fun onCreate() {
        super.onCreate()
        JodaTimeAndroid.init(this)
        Util.getTimeZone("MainApplication")

        runBlocking {
            launch (Dispatchers.IO) {
                Util.getTimeZone("Dispatchers.IO")
            }
        }

        startService(Intent(this, MainService::class.java))

        sync()
    }

    private fun createSyncAccountIfNecessary() {
        if (accountManager.addAccountExplicitly(defaultSyncAccount, null, null)) {
            ContentResolver.setIsSyncable(account, AUTHORITY, 1)
        }
    }

    private fun sync() {
        val bundle = Bundle()
        bundle.putBoolean(ContentResolver.SYNC_EXTRAS_MANUAL, true)
        bundle.putBoolean(ContentResolver.SYNC_EXTRAS_EXPEDITED, true)
        ContentResolver.requestSync(account, AUTHORITY, bundle)
    }
}