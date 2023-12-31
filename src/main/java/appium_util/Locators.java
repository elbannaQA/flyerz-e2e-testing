package appium_util;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
public class Locators {

   public By next_Btn = AppiumBy.id("in.converted.flyerz.debug:id/btn_next");
   public By skip_Btn = AppiumBy.id("in.converted.flyerz.debug:id/tv_skip");
   public By phone_number_text_field = AppiumBy.id("in.converted.flyerz.debug:id/et_phone_number");
   public By first_name_field = AppiumBy.id("in.converted.flyerz.debug:id/et_first_name");
   public By last_name_field = AppiumBy.id("in.converted.flyerz.debug:id/et_last_name");
   public By save_Btn = AppiumBy.id("in.converted.flyerz.debug:id/btn_save");
   public By otp_field = AppiumBy.className("android.widget.EditText");
   public By confirm_Btn = AppiumBy.id("in.converted.flyerz.debug:id/btn_confirm");
   public By allowNotificationBtn = AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button");
   public By cancel_permission_popup = AppiumBy.id("android:id/button2");
   public By closeInvitationPopup = AppiumBy.id("in.converted.flyerz.debug:id/iv_close");
   //public By welcome_message = AppiumBy.id("in.converted.flyerz.debug:id/tv_statistics");
   public By startYourAdd_text = AppiumBy.id("in.converted.flyerz.debug:id/tv_start_now");
   public By close_tab_button = AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Close tab\"]");
   public By settings_button = AppiumBy.accessibilityId("الاعدادات");
   public By editProfile_button = AppiumBy.id("in.converted.flyerz.debug:id/tv_edit_profile");
   public By email_field = AppiumBy.id("in.converted.flyerz.debug:id/et_email");
   public By updatePhoneNumber_btn = AppiumBy.id("in.converted.flyerz.debug:id/btn_update_phone");
   public By name_text = AppiumBy.id("in.converted.flyerz.debug:id/tv_name");
   public By validation_msg = AppiumBy.id("in.converted.flyerz.debug:id/snackbar_text");
   public By myAccounts_btn = AppiumBy.id("in.converted.flyerz.debug:id/tv_my_accounts");
   public By changePage_btn = AppiumBy.id("in.converted.flyerz.debug:id/tv_change_page");
   public By selectPage_btn = AppiumBy.className("android.widget.RadioButton");
   public By selectCategory_btn = AppiumBy.className("androidx.recyclerview.widget.RecyclerView");
   public By pageName_txt = AppiumBy.id("in.converted.flyerz.debug:id/tv_page_name");
   public By pageNames_txt = AppiumBy.id("in.converted.flyerz.debug:id/tv_name");
   public By createAd_btn = AppiumBy.id("in.converted.flyerz.debug:id/v_create_ad");
   public By continue_btn = AppiumBy.id("in.converted.flyerz.debug:id/btn_continue");
   public By fb_channel_btn = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout" +
           "/android.widget.FrameLayout/android.widget.LinearLayout" +
           "/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView" +
           "/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView" +
           "/android.widget.FrameLayout[1]/android.view.ViewGroup");
   public By page_likes_goal = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout" +
           "/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
           "/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup" +
           "/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView" +
           "/android.view.ViewGroup[1]/android.view.ViewGroup");
   public By post_engagement_goal = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout" +
           "/android.widget.LinearLayout/android.widget.FrameLayout" +
           "/android.widget.LinearLayout/android.widget.FrameLayout" +
           "/android.view.ViewGroup/android.widget.ScrollView" +
           "/android.view.ViewGroup/android.widget.LinearLayout" +
           "/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup");

   public By messages_goal = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout" +
           "/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
           "/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup" +
           "/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView" +
           "/android.view.ViewGroup[3]/android.view.ViewGroup");
   public By create_ad_btn = AppiumBy.id("in.converted.flyerz.debug:id/btn_create");
   public By selectCountry_ddl = AppiumBy.id("in.converted.flyerz.debug:id/tv_select_country");
   public By select_post_btn = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout" +
           "/android.widget.LinearLayout/android.widget.FrameLayout" +
           "/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup" +
           "/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]" +
           "/android.view.ViewGroup");
   public By successful_message_create_ads_txt = AppiumBy.id("in.converted.flyerz.debug:id/tv_title1");
   public By selectCountry_btn = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView");
   public By selectCities_ddl = AppiumBy.id("in.converted.flyerz.debug:id/tv_search_cities");
   public By selectCities_btn = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView");
   public By budget_txt = AppiumBy.id("in.converted.flyerz.debug:id/et_budget");
   public By currency_sign = AppiumBy.id("in.converted.flyerz.debug:id/tv_currency");
   public By back_to_homePage_btn = AppiumBy.id("in.converted.flyerz.debug:id/btn_skip");
   public By adTxt = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[1]/android.view.ViewGroup/android.widget.TextView[1]");
   public By adStatus = AppiumBy.id("in.converted.flyerz.debug:id/tv_ad_status_value");
   public By adBudget = AppiumBy.id("in.converted.flyerz.debug:id/tv_value");
   public By walletBtn = AppiumBy.accessibilityId("المحفظة");
   public By addBalanceBtn = AppiumBy.id("in.converted.flyerz.debug:id/tv_add_budget");
   public By selectVodafoneCash = AppiumBy.xpath("//android.widget.TextView[@text='الدفع من خلال محفظة فودافون']");
   public By selectPaymob = AppiumBy.xpath("//android.widget.TextView[@text='الدفع من خلال كارت بنكي']");
   public By userPinTxt = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View[1]/android.widget.EditText");
   public By userOtpTxt = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View[2]/android.widget.EditText");
   public By payBtn = AppiumBy.className("android.widget.Button");
   public By successPaymentMessageTxt = AppiumBy.id("in.converted.flyerz.debug:id/tv_text");
   public By okBtn = AppiumBy.id("in.converted.flyerz.debug:id/btn_ok");
   public By cardNumberTxt = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View/android.widget.EditText[1]");
   public By cardHolderNameTxt = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View/android.widget.EditText[2]");
   public By expiryDateTxt = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View/android.widget.EditText[3]");
   public By cvvTxt = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View/android.widget.EditText[4]");
   public  By earnMoneyTab = AppiumBy.id("in.converted.flyerz.debug:id/tv_earn");
   public By changeCodeBtn = AppiumBy.id("in.converted.flyerz.debug:id/tv_identify");
   public By invitationCodeField = AppiumBy.id("in.converted.flyerz.debug:id/et_change_code");
   public By  invitationCodeTxt= AppiumBy.id("in.converted.flyerz.debug:id/et_code");
   public By enterInvitationCodeField = AppiumBy.id("in.converted.flyerz.debug:id/et_invitation_code");
   public By useBtn = AppiumBy.id("in.converted.flyerz.debug:id/btn_use");
   public By codeSuccessMsg = AppiumBy.id("in.converted.flyerz.debug:id/tv_code_success");


}
