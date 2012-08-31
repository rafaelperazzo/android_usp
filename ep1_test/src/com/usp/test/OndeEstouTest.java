package com.usp.test;

import android.test.ActivityInstrumentationTestCase2;
import br.usp.ime.ep1.OndeEstou;
import br.usp.ime.ep1.Util;

import com.jayway.android.robotium.solo.Solo;


public class OndeEstouTest extends ActivityInstrumentationTestCase2<OndeEstou> {

private Solo robo;
	
	public OndeEstouTest() {
		super("br.usp.ime.ep1",OndeEstou.class);
	}
	
	@Override
    protected void setUp() throws Exception {
        super.setUp();
        robo = new Solo(getInstrumentation(), getActivity());
        robo.finishInactiveActivities();
    }
	
	
	public void testAGPS_P1() {
		
        Util.LATITUDE = -23.564194; //p1
        Util.LONGITUDE = -46.714802; //p1
        robo.pressMenuItem(6);
					
	}
	
	public void testAGPS_P2() {
		Util.LATITUDE =-23.553110; //p2
        Util.LONGITUDE = -46.727483; //p2
        robo.pressMenuItem(6);
	}
	
	public void testAGPS_P3() {
		Util.LATITUDE = -23.568068; //p3
        Util.LONGITUDE = -46.735910; //p3
        robo.pressMenuItem(6);
	}
	
	public void testMenuLimpar() {
		robo.pressMenuItem(0);
	}
	
	public void testMenuCircular1() {
		robo.pressMenuItem(1);
	}
	
	public void testMenuCircular2() {
		robo.pressMenuItem(3);
	}
	
	public void testMenuRedesenhar() {
		robo.pressMenuItem(5);
	}
	
	public void testMenuEnviarCoordenadas() {
		robo.pressMenuItem(6);
	}
	
	public void testMenuP1() {
		robo.pressMenuItem(8);
		robo.sendKey(Solo.ENTER);
	}
	
	public void testMenuP2() {
		robo.pressMenuItem(8);
		robo.sendKey(Solo.DOWN);
		robo.sendKey(Solo.ENTER);
	}
	
	public void testMenuP3() {
		robo.pressMenuItem(8);
		robo.sendKey(Solo.DOWN);
		robo.sendKey(Solo.DOWN);
		robo.sendKey(Solo.ENTER);
	}
	
	public void testTamanhoFila() {
		robo.pressMenuItem(8);
		robo.sendKey(Solo.DOWN);
		robo.sendKey(Solo.DOWN);
		robo.sendKey(Solo.DOWN);
		robo.sendKey(Solo.ENTER);
	}
	
	protected void tearDown() throws Exception {
		try {
			robo.finishInactiveActivities();
			robo.finishOpenedActivities();
			robo.finalize();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		getActivity().finish();
		super.tearDown();
    }
	
}
