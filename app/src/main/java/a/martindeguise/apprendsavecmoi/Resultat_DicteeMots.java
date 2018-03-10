package a.martindeguise.apprendsavecmoi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by martin on 12/01/2018.
 */

public class Resultat_DicteeMots extends AppCompatActivity{

    final String EXTRA_RESULTATUSER = "resultatUser";
    final String EXTRA_RESULTAT = "resultat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_resultat_dictee_mots);

        // Création bouton retour accueil avec moi
        final ImageButton accueilButton= findViewById(R.id.imageButton3);
        accueilButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Resultat_DicteeMots.this, Acceuil.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();

        // Affichage du resultat
        TextView textView9 = findViewById(R.id.textView70); // Vrai resultat
        TextView textView7 = findViewById(R.id.textView71); // Resultat donnée par l'utilisateur
        TextView textView8 = findViewById(R.id.textView72); // Dire a l'utilisateur si son resultat est bon ou pas

        if (intent != null) {
            textView9.setText(intent.getStringExtra(EXTRA_RESULTAT));
            textView7.setText(intent.getStringExtra(EXTRA_RESULTATUSER));

            String resultat = EXTRA_RESULTAT;
            String resultatUser = EXTRA_RESULTATUSER;

            //Affichage du message pour savoir si le resultat donnée par l'utilisateur est bon ou pas
            if (resultat.equals(resultatUser)){
                textView8.setText("Bon");
            }
            else{
                textView8.setText("Pas bon");
            }
        }
    }
}
