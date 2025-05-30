package io.github.ponnamkarthik.toast.fluttertoast_no_web

import android.content.Context
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.MethodChannel

/** FluttertoastNoWebPlugin */
public class FluttertoastNoWebPlugin: FlutterPlugin {

  private var channel: MethodChannel? = null

  override fun onAttachedToEngine(binding: FlutterPlugin.FlutterPluginBinding,) {
    setupChannel(binding.binaryMessenger, binding.applicationContext,)
  }

  override fun onDetachedFromEngine(p0: FlutterPlugin.FlutterPluginBinding,) {
    teardownChannel();
  }

  private fun setupChannel(messenger: BinaryMessenger, context: Context,) {
    channel = MethodChannel(messenger, "PonnamKarthik/fluttertoast_no_web",)
    val handler = MethodCallHandlerImpl(context,)
    channel?.setMethodCallHandler(handler,)
  }

  private fun teardownChannel() {
    channel?.setMethodCallHandler(null,)
    channel = null
  }

}

