package tat.mukhutdinov.lesson19

import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import tat.mukhutdinov.lesson19.ui.BluromaticScreen
import tat.mukhutdinov.lesson19.ui.theme.BluromaticTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            BluromaticTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    BluromaticScreen()
                }
            }
        }
    }
}

fun Context.getImageUri(): Uri {
    val resources = this.resources

    return Uri.Builder()
        .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
        .authority(resources.getResourcePackageName(R.drawable.android_cupcake))
        .appendPath(resources.getResourceTypeName(R.drawable.android_cupcake))
        .appendPath(resources.getResourceEntryName(R.drawable.android_cupcake))
        .build()
}
