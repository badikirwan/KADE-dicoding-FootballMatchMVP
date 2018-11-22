package com.badikirwan.dicoding.footballmatch.util

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class TestContextProvider: CoroutineContextProvider() {
    override val main: CoroutineContext = Dispatchers.Unconfined
}