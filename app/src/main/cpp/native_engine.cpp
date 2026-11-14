#include <jni.h>

namespace {
constexpr char kEngineVersion[] = "DAMAS Native Engine 0.1.0 (C++17)";
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_huzeifa_damas_engine_NativeEngine_nativeEngineVersion(
    JNIEnv* env,
    jclass /* clazz */
) {
    return env->NewStringUTF(kEngineVersion);
}
