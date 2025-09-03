package com.anywhere.wechat.uitis

import android.content.Intent
import android.os.Bundle

object WeChatHelper {
    fun CreatItent(code:String,appPackage:String,appId:String,state:String):Intent{
        var schemeUri ="$appId$//oauth?code=$code$"

        val intent = Intent()
        intent.setClassName(appPackage!!, "$appPackage.wxapi.WXEntryActivity")
        val bundle = Bundle()
        bundle.putString("_wxapi_sendauth_resp_state", state)
        bundle.putString("_wxapi_sendauth_resp_token", code)
        bundle.putString("_wxapi_baseresp_transaction", "")
        bundle.putString("_wxapi_sendauth_resp_lang", "zh_CN")
        bundle.putInt("_wxapi_command_type", 1)
        bundle.putString("_wxapi_sendauth_resp_country", "CN")
        bundle.putString("wx_token_key", "com.tencent.mm.openapi.token")
        bundle.putString("_wxapi_sendauth_resp_url", schemeUri)
        bundle.putInt("_wxapi_baseresp_errcode", 0)
        bundle.putString("_wxapi_baseresp_errstr", null)
        bundle.putString("_wxapi_baseresp_openId", null)
        intent.putExtras(bundle)
        intent.putExtra("_wxapi_sendauth_resp_auth_result", true)
        intent.putExtra("_mmessage_sdkVersion", 621086464)
        intent.putExtra("_mmessage_appPackage", "com.tencent.mm")
        intent.putExtra("_mmessage_content", "")
        val cksum = byteArrayOf(50, 54, 56, 53, 55, 51, 102, 53, 102, 50, 99, 50, 52, 56, 57, 100, 57, 53, 53, 51, 99, 55, 52, 99, 51, 102, 99, 101, 56, 100, 97, 50)
        intent.putExtra("_mmessage_checksum", cksum)
        intent
            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            .addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK)
        return intent
    }
}