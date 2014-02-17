package com.wedy.atokpro;

import android.content.res.XModuleResources;
import de.robv.android.xposed.IXposedHookInitPackageResources;
import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.callbacks.XC_InitPackageResources.InitPackageResourcesParam;

public class NotificationiconPatcher implements IXposedHookZygoteInit, IXposedHookInitPackageResources{

	private static final String PACKAGE_ESF = "com.justsystems.atokmobile2.pv.service";
	private static String modulePath = null;

	@Override
	public void initZygote(StartupParam startupParam) throws Throwable {
		modulePath = startupParam.modulePath;
	}

	@Override
	public void handleInitPackageResources(InitPackageResourcesParam resparam) throws Throwable {
		if(!resparam.packageName.equals(PACKAGE_ESF)){
			return;
		}

		XModuleResources modRes = XModuleResources.createInstance(modulePath, resparam.res);
resparam.res.setReplacement(PACKAGE_ESF, "drawable", "icon_hiragana", modRes.fwd(R.drawable.aa));
resparam.res.setReplacement(PACKAGE_ESF, "drawable", "icon_alphabet", modRes.fwd(R.drawable.aa));
resparam.res.setReplacement(PACKAGE_ESF, "drawable", "icon_number", modRes.fwd(R.drawable.aa));

	}

}
