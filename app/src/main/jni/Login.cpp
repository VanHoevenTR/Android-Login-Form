#include <jni.h>
#include <string>
#include "Includes/obfuscate.h"
#include "Includes/Logger.h"
#include "Includes/Utils.h"

bool urlEnabled = false;
bool loginEnabled = false;
bool login2Enabled = false;

extern "C" {
JNIEXPORT jstring
JNICALL
Java_yt_mahmoudgaming_login_LoginForm_URL(JNIEnv *env, jobject thiz) {
    urlEnabled = true;

    //Use 000webhostapp.com for free hosting
    return env->NewStringUTF(OBFUSCATE("https://example.000webhostapp.com/Login.php"));
}
}
extern "C" {
JNIEXPORT jstring
JNICALL
Java_yt_mahmoudgaming_login_LoginForm_Login(JNIEnv *env, jobject thiz) {
    loginEnabled = true;

    //Html is supported
    return env->NewStringUTF(OBFUSCATE("Modded by (Mahmoud Gaming)"));
}
}
extern "C" {
JNIEXPORT jstring
JNICALL
Java_yt_mahmoudgaming_login_LoginForm_Login2(JNIEnv *env, jobject thiz) {
    login2Enabled = true;

    //Html is supported
    return env->NewStringUTF(OBFUSCATE("∆ Please login First to Play Game | Mod Menu By Mahmoud Gaming ∆"));
}
}
