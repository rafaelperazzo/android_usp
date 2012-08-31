package com.usp.test;
import android.test.ActivityInstrumentationTestCase2;
import br.usp.ime.ep1.ConfiguracoesGerais;

import com.jayway.android.robotium.solo.Solo;


public class ConfiguracoesTest extends ActivityInstrumentationTestCase2<ConfiguracoesGerais> {

private Solo robo;
	
	public ConfiguracoesTest() {
		super("br.usp.ime.ep1",ConfiguracoesGerais.class);
	}
	
	@Override
    protected void setUp() throws Exception {
        super.setUp();
        robo = new Solo(getInstrumentation(), getActivity());
    }
	
	public void testCancelar() {
		robo.clickOnButton(1);
	}
	
	public void testSalvar() {
		robo.clickOnButton(0);
	}
	
	protected void tearDown() throws Exception {
		try {
			robo.finalize();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		getActivity().finish();
		super.tearDown();
    }
	
}
