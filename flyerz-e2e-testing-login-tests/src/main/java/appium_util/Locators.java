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
   public By cancel_permission_popup = AppiumBy.id("android:id/button2");
   public By welcome_message = AppiumBy.id("in.converted.flyerz.debug:id/tv_statistics");
   public By close_tab_button = AppiumBy.accessibilityId("Close tab");
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
   public By createAd_btn = AppiumBy.id("in.converted.flyerz.debug:id/btn_add_ad");
   public By createAds_nextBtn = AppiumBy.id("in.converted.flyerz.debug:id/btn_next_step");
   public By select_adsGoal = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout" +
           "/android.widget.FrameLayout/android.widget.LinearLayout" +
           "/android.widget.FrameLayout/android.view.ViewGroup" +
           "/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView" +
           "/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup" +
           "/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]" +
           "/android.view.ViewGroup");

   public By select_post_btn = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView");
   public By selectCountry_ddl = AppiumBy.id("in.converted.flyerz.debug:id/tv_select_country");
   public By selectCountry_btn = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView");
   public By selectCities_ddl = AppiumBy.id("in.converted.flyerz.debug:id/tv_search_cities");
   public By selectCities_btn = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView");
   public By budget_txt = AppiumBy.id("in.converted.flyerz.debug:id/et_budget");
   public By currency_sign = AppiumBy.id("in.converted.flyerz.debug:id/tv_currency");
   public By back_to_homePage_btn = AppiumBy.id("in.converted.flyerz.debug:id/btn_skip");
   public By adTxt = AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[1]/android.view.ViewGroup/android.widget.TextView[1]");
   public By adStatus = AppiumBy.id("in.converted.flyerz.debug:id/tv_ad_status_value");
   public By adBudget = AppiumBy.id("in.converted.flyerz.debug:id/tv_value");

}
