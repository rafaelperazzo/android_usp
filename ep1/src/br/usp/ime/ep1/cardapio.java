package br.usp.ime.ep1;



import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
/**
 * Activity que representa o cardápio da semana do restaurante selecionado
 * @author Rafael Perazzo, Luiz Carlos, Maciel Caleb
 *
 */
public class cardapio extends Activity {
	WebView webview;
	Util u;
	
	/**
	 * Abre uma webview para mostrar o cardápio selecionado
	 */
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardapio);
        webview = (WebView) findViewById(R.id.webviewcardapio);
        webview.getSettings().setJavaScriptEnabled(true);
        u = new Util();
		webview.loadData(u.getTabela(u.carregarCardapioOffline(Util.restauranteOFFLINE)), "text/html",null);
    }
}
