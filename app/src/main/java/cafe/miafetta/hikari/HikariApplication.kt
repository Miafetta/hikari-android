package cafe.miafetta.hikari

import android.app.Application
import com.google.android.material.color.DynamicColors

class HikariApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        DynamicColors.applyToActivitiesIfAvailable(this)
    }
}
