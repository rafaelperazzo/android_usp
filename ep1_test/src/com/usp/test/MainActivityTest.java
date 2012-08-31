package com.usp.test;

import android.content.Context;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import br.usp.ime.ep1.ConfiguracoesGerais;
import br.usp.ime.ep1.Gravador;
import br.usp.ime.ep1.OndeEstou;
import br.usp.ime.ep1.Sobre;
import br.usp.ime.ep1.Util;
import br.usp.ime.ep1.bandeijao;
import br.usp.ime.ep1.main;

import com.jayway.android.robotium.solo.Solo;
import br.usp.ime.ep1.R;

public class MainActivityTest extends ActivityInstrumentationTestCase2<main> {

	private main mActivity;  
    private Button bandejao;
    private String bandejaoString;
    private String mapaString;
    private Util u;
    private Context c;
    Solo robo;

	
	public MainActivityTest() {
		super("br.usp.ime.ep1",main.class);
		
	}
	
	@Override
    protected void setUp() throws Exception {
        super.setUp();
        mActivity = this.getActivity();
        bandejao = (Button) mActivity.findViewById(R.id.btnBandeijao);
        bandejaoString = "Bandeijão";
        mapaString = "Mapa da USP";
        u = new Util();
        c = mActivity.getApplicationContext();
        robo = new Solo(getInstrumentation(), getActivity());
        
    }
	
	/*
	 * Testes da Activity main
	 */
	
	public void testPreconditions() {
	      assertNotNull(bandejao);
	    }
	    
	public void testTextBotaoBandejao() {
	      assertEquals(bandejaoString,(String)bandejao.getText());
	}
	
	public void testTextBotaoMapa() {
	      assertEquals(mapaString,"Mapa da USP");
	}
	
	public void testClickBandejao() {
		robo.clickOnButton(0);
		robo.assertCurrentActivity("Activity errada", bandeijao.class);
		robo.goBack();
	}
	
	public void testClickMapa() {
		robo.clickOnButton(1);
		robo.assertCurrentActivity("Activity errada", OndeEstou.class);
		robo.goBack();
	}
	
	public void testMenuSobre() {
		robo.pressMenuItem(1);
		robo.assertCurrentActivity("Activity errada", Sobre.class);
		robo.goBack();
	}
	
	public void testMenuSair() {
		robo.pressMenuItem(0);
	}
	
	public void testMenuConfiguracoes() {
		robo.pressMenuItem(2);
		robo.assertCurrentActivity("Activity errada", ConfiguracoesGerais.class);
		robo.goBack();
	}
	
	/*
	 * Testes da Classe Util
	 */
	
	public void testPossuiInternet() {
		assertTrue(u.possuiInternet()==true);
	}
	
	public void testIniciar() {
		assertTrue(Util.iniciar(c));
	}
	
	public void testGetCardapio() {
		assertNotNull(u.getCardapio("http://www.usp.br/coseas/cardapio.html"));
	}
	
	public void testGetURL() {
		assertNotNull(u.getURL("http://www.usp.br/coseas/cardapio.html"));
	}
	
	public void testMostraMensagem() {
		assertTrue(u.MostraMensagem(c, "Testando mensagem..."));
		assertTrue(u.MostraMensagem(c, "Testando mensagem",100));
	}
	
	public void testGetTabela() {
		assertNotNull(u.getTabela(u.getURL("http://www.usp.br/coseas/cardapio.html")));
	}
	
	public void testGetCardapioOffline() {
		assertTrue(u.gravarCardapioOffline("http://www.usp.br/coseas/cardapio.html", "teste.html"));
	}
	
	public void testCarregarCardapioOffline() {
		assertNotNull(u.carregarCardapioOffline("teste.html"));
	}
	
	public void testAtualizar() {
    	if (u.possuiInternet()) {
    		Gravador rec = new Gravador();
    		rec.gravar();
    		assertFalse(u.atualizar());
    	}
    	else {
    		assertEquals(true, true);
    	}
    	
	}
	
	public void testExisteCacheCentral() {
		assertTrue(u.existeCache());
	}
	
	public void testExisteCache() {
		assertTrue(Util.existeCache("ccentral.html"));
	}
	
	public void testGetDistancia() {
		
	}
	
	public void testGetProperties() {
		assertNotNull(Util.getProperties(c, "main.properties"));
	}
	
	public void testCarregarCardapioOfflinePos() {
		assertTrue(Util.carregarCardapioOffline(2));
	}
	
	public void testGetRestauranteMaisPerto() {
		assertEquals(2, Util.getRestauranteMaisPerto(c));
	}
	
	public void testCSV2arquivoCache() {
		assertTrue(Util.csv2arquivoCache(c, "linha1.csv"));
	}
	
	public void testGravarEmArquivo() {
		assertTrue(Util.gravarEmArquivo(Util.SERVIDOR + Util.BANDEIJAO, Util.BANDEIJAO + ".json"));
	}
	
	public void testConverterString() {
		assertEquals("aeioec",Util.converterString("áéíóêç"));
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
