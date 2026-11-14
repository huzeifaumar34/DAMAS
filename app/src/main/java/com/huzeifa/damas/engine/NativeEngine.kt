package com.huzeifa.damas.engine

/**
 * JNI bridge proving that Android can load the C++ engine.
 * Game rules and search routines will be added in later phases.
 */
internal object NativeEngine {
    private val libraryLoaded: Boolean = runCatching {
        System.loadLibrary("damas_engine")
    }.isSuccess

    fun version(): String {
        if (!libraryLoaded) return "Motor nativo indisponível nesta arquitetura"
        return runCatching { nativeEngineVersion() }
            .getOrElse { "Motor nativo carregado" }
    }

    @JvmStatic
    private external fun nativeEngineVersion(): String
}
