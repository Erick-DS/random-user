package com.example.randomuser.core

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Base Application used it for hilt injection
 */
@HiltAndroidApp
class BaseApplication : Application()