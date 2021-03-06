package com.appboy.ui.inappmessage.listeners;

import android.view.View;

import com.appboy.models.IInAppMessage;
import com.appboy.models.IInAppMessageThemeable;
import com.appboy.models.MessageButton;
import com.appboy.ui.inappmessage.AppboyInAppMessageManager;
import com.appboy.ui.inappmessage.InAppMessageCloser;
import com.appboy.ui.inappmessage.InAppMessageOperation;
import com.appboy.ui.support.ViewUtils;

public class AppboyDefaultInAppMessageManagerListener implements IInAppMessageManagerListener {
  @Override
  @Deprecated
  public boolean onInAppMessageReceived(IInAppMessage inAppMessage) {
    return false;
  }

  @Override
  public InAppMessageOperation beforeInAppMessageDisplayed(IInAppMessage inAppMessage) {
    if (inAppMessage instanceof IInAppMessageThemeable && ViewUtils.isDeviceInNightMode(AppboyInAppMessageManager.getInstance().getApplicationContext())) {
      ((IInAppMessageThemeable) inAppMessage).enableDarkTheme();
    }
    return InAppMessageOperation.DISPLAY_NOW;
  }

  @Override
  public boolean onInAppMessageClicked(IInAppMessage inAppMessage, InAppMessageCloser inAppMessageCloser) {
    return false;
  }

  @Override
  public boolean onInAppMessageButtonClicked(IInAppMessage inAppMessage, MessageButton button, InAppMessageCloser inAppMessageCloser) {
    return false;
  }

  @Override
  public void onInAppMessageDismissed(IInAppMessage inAppMessage) { }

  @Override
  public void beforeInAppMessageViewOpened(View inAppMessageView, IInAppMessage inAppMessage) { }

  @Override
  public void afterInAppMessageViewOpened(View inAppMessageView, IInAppMessage inAppMessage) { }

  @Override
  public void beforeInAppMessageViewClosed(View inAppMessageView, IInAppMessage inAppMessage) { }

  @Override
  public void afterInAppMessageViewClosed(IInAppMessage inAppMessage) { }
}
