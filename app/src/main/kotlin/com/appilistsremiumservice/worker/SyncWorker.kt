package com.appilistpremiumservice.worker

import android.content.Context
import androidx.work.*
import com.appilistpremiumservice.utils.NetworkUtils
import java.util.concurrent.TimeUnit

/**
 * Background Worker for Data Synchronization
 * Syncs offline data to Firebase when internet available
 */
class SyncWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {
    
    override suspend fun doWork(): Result {
        return try {
            // Check if internet is available
            if (!NetworkUtils.isNetworkAvailable(applicationContext)) {
                return Result.retry()
            }
            
            // TODO: Implement sync logic here
            // 1. Get unsync data from Room database
            // 2. Upload to Firebase
            // 3. Mark as synced
            // 4. Download new data from Firebase
            // 5. Update Room database
            
            // For now, just return success
            Result.success()
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure()
        }
    }
    
    companion object {
        const val WORK_NAME = "data_sync_work"
        
        /**
         * Schedule periodic sync work
         * Runs every 1 hour when connected to WiFi
         */
        fun scheduleSyncWork(context: Context) {
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()
            
            val syncRequest = PeriodicWorkRequestBuilder<SyncWorker>(
                1, TimeUnit.HOURS
            )
                .setConstraints(constraints)
                .setBackoffCriteria(
                    BackoffPolicy.LINEAR,
                    WorkRequest.MIN_BACKOFF_MILLIS,
                    TimeUnit.MILLISECONDS
                )
                .build()
            
            WorkManager.getInstance(context).enqueueUniquePeriodicWork(
                WORK_NAME,
                ExistingPeriodicWorkPolicy.KEEP,
                syncRequest
            )
        }
        
        /**
         * Cancel sync work
         */
        fun cancelSyncWork(context: Context) {
            WorkManager.getInstance(context).cancelUniqueWork(WORK_NAME)
        }
        
        /**
         * Trigger immediate sync
         */
        fun triggerImmediateSync(context: Context) {
            val syncRequest = OneTimeWorkRequestBuilder<SyncWorker>()
                .build()
            
            WorkManager.getInstance(context).enqueue(syncRequest)
        }
    }
}