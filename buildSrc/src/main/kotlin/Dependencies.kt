object Dependencies {
    val corektx            by lazy { "androidx.core:core-ktx:${Versions.appcompat}" }
    val appcompat          by lazy { "androidx.appcompat:appcompat:${Versions.appcompat}" }
    val material           by lazy { "com.google.android.material:material:${Versions.material}" }
    val junit              by lazy { "junit:junit:${Versions.junit}" }
    val junitext           by lazy { "androidx.test.ext:junit:${Versions.junitext}" }
    val expresso           by lazy { "androidx.test.ext:junit:${Versions.espresso}" }
    val koin               by lazy { "io.insert-koin:koin-android:${Versions.koin}" }
    val roomruntime        by lazy { "androidx.room:room-runtime:${Versions.room}" }
    val roomcompiler       by lazy { "androidx.room:room-compiler:${Versions.room}" }
    val roomktx            by lazy { "androidx.room:room-ktx:${Versions.room}" }
    val roomtesting        by lazy { "androidx.room:room-testing:${Versions.room}" }
    val lifecycleviewmodel by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}" }
    val lifecyclelivedata  by lazy { "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}" }
    val lifecycleruntime   by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}" }
    val constraintlayout   by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraint}" }
    val navigationui       by lazy { "androidx.navigation:navigation-ui-ktx:${Versions.navigation}" }
    val navigationfragment by lazy { "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}" }
}