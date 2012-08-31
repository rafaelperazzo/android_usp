package com.usp.test;

import android.test.ActivityInstrumentationTestCase2;
import br.usp.ime.ep1.SemidroidActivity;

import com.jayway.android.robotium.solo.Solo;

public class SemidroidActivityTest extends ActivityInstrumentationTestCase2<SemidroidActivity>{

	private Solo robo;
	
	public SemidroidActivityTest() {
		super("br.usp.ime.ep1",SemidroidActivity.class);
	}
	
	@Override
    protected void setUp() throws Exception {
        super.setUp();
        robo = new Solo(getInstrumentation(), getActivity());
        robo.finishInactiveActivities();
    }
	
	public void testSeminariosDeHoje() {
		robo.clickInList(0);
		robo.finishOpenedActivities();
	}
	
	public void testSeminariosPorArea() {
		robo.clickInList(2);
		robo.finishOpenedActivities();
	}
	
	public void testPesquisarSeminarios() {
		robo.clickInList(3);
		robo.finishOpenedActivities();
	}
	
	public void testRequisitarAtualizacao() {
		robo.clickInList(1);
		robo.finishOpenedActivities();
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