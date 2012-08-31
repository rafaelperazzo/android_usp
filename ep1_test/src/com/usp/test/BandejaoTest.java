package com.usp.test;

import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import br.usp.ime.ep1.bandeijao;

import com.jayway.android.robotium.solo.Solo;

public class BandejaoTest extends ActivityInstrumentationTestCase2<bandeijao> {

	private Solo robo;
	
	public BandejaoTest() {
		super("br.usp.ime.ep1",bandeijao.class);
		
	}
	
	@Override
    protected void setUp() throws Exception {
        super.setUp();
        robo = new Solo(getInstrumentation(), getActivity());
        robo.finishInactiveActivities();
    }
	
	public void testClickCardapio1() {
		robo.pressSpinnerItem(0, 1);
		robo.clickOnImageButton(0);
		robo.finishOpenedActivities();
		
	}
	
	public void testClickCardapio2() {
		robo.pressSpinnerItem(0, 2);
		robo.clickOnImageButton(0);
		robo.finishOpenedActivities();
		
	}
	
	public void testClickCardapio3() {
		robo.pressSpinnerItem(0, 3);
		robo.clickOnImageButton(0);
		robo.finishOpenedActivities();
		
	}
	
	public void testClickPostarComentarios1() {
		robo.pressSpinnerItem(0, 1);
		robo.clickOnImageButton(2);
		robo.finishOpenedActivities();
	}
	
	public void testClickPostarComentarios2() {
		robo.pressSpinnerItem(0, 2);
		robo.clickOnImageButton(2);
		robo.finishOpenedActivities();
	}
	
	public void testClickPostarComentarios3() {
		robo.pressSpinnerItem(0, 3);
		robo.clickOnImageButton(2);
		robo.finishOpenedActivities();
	}
	
	public void testClickPostarComentarios4() {
		robo.pressSpinnerItem(0, 4);
		robo.clickOnImageButton(2);
		robo.finishOpenedActivities();
	}
	
	public void testClickPostarComentarios5() {
		robo.pressSpinnerItem(0, 5);
		robo.clickOnImageButton(2);
		robo.finishOpenedActivities();
	}

	public void testClickComentarios1() {
		robo.pressSpinnerItem(0, 1);
		robo.clickOnImageButton(1);
		robo.goBack();
		robo.finishOpenedActivities();
		
	}
	
	public void testClickComentarios2() {
		robo.pressSpinnerItem(0, 2);
		robo.clickOnImageButton(1);
		robo.goBack();
		robo.finishOpenedActivities();
		
	}
	
	public void testClickComentarios3() {
		robo.pressSpinnerItem(0, 3);
		robo.clickOnImageButton(1);
		robo.goBack();
		robo.finishOpenedActivities();
		
	}
	
	public void testClickComentarios4() {
		robo.pressSpinnerItem(0, 4);
		robo.clickOnImageButton(1);
		robo.goBack();
		robo.finishOpenedActivities();
	}
	
	public void testClickComentarios5() {
		robo.pressSpinnerItem(0, 5);
		robo.clickOnImageButton(1);
		robo.goBack();
		robo.finishOpenedActivities();
	}
	
	public void testRecarregar() {
		robo.pressMenuItem(0);
	}
	
	public void testSpinner() {
		robo.pressSpinnerItem(0, 1);
	}
	
	public void testSpinner2() {
		robo.pressSpinnerItem(0, 2);
	}
	
	public void testSpinner3() {
		robo.pressSpinnerItem(0, 3);
	}

	public void testSpinner4() {
		robo.pressSpinnerItem(0, 4);
	}

	public void testSpinner5() {
		robo.pressSpinnerItem(0, 5);
	}
	
	@Override
    protected void tearDown() throws Exception {
		try {
			robo.finishInactiveActivities();
			robo.finishOpenedActivities();
			robo.finalize();
		} catch (Throwable e) {
			Log.e("SOLO", e.getMessage());
		}
		super.tearDown();
    }
	
}
