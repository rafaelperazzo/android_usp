package com.usp.test;

import android.test.ActivityInstrumentationTestCase2;
import br.usp.ime.ep1.PostarComentario;

import com.jayway.android.robotium.solo.Solo;

public class PostarComentarioTest extends ActivityInstrumentationTestCase2<PostarComentario> {

private Solo robo;
	
	public PostarComentarioTest() {
		super("br.usp.ime.ep1",PostarComentario.class);
		
	}
	
	@Override
    protected void setUp() throws Exception {
        super.setUp();
        robo = new Solo(getInstrumentation(), getActivity());
    }
	
	public void testPostarComentario() {
		robo.enterText(0, "Refeição boa!");
		robo.pressSpinnerItem(0, 2);
		robo.clickOnButton(0);
	}
	
	@Override
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
