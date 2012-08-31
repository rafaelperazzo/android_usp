package com.usp.test;

import android.test.ActivityInstrumentationTestCase2;
import br.usp.ime.ep1.Comentarios;

import com.jayway.android.robotium.solo.Solo;

public class ComentariosTest extends ActivityInstrumentationTestCase2<Comentarios> {

private Solo robo;
	
	public ComentariosTest() {
		super("br.usp.ime.ep1",Comentarios.class);
	}
	
	@Override
    protected void setUp() throws Exception {
        super.setUp();
        robo = new Solo(getInstrumentation(), getActivity());
    }
	
	public void testComentarios() {
		robo.finishOpenedActivities();
	}
	
}
