package com.example.consultoria;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class NavegacacaoActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navegacacao);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarEmail();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_principal,R.id.nav_servico,R.id.nav_clientes,
                R.id.nav_contato, R.id.nav_sobre)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

        public void enviarEmail(){
        String telefone = "tel:923567864";
        String image ="https://epocanegocios.globo.com/Empresa/noticia/2020/09/para-atrair-clientes-resort-nas-maldivas-lanca-pacote-de-home-office-de-luxo-por-us-23-mil.html";
        String endereco ="https://www.google.com/maps?q=colombo+lisboa&um=1&ie=UTF-8&sa=X&ved=2ahUKEwjei6jV_KHwAhXJ6eAKHQ2FCbUQ_AUoAXoECAEQAw";
            // Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(telefone));
            //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(imagem);
            // Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(image));

            Intent intent = new Intent(Intent.ACTION_SEND);

            intent.putExtra(Intent.EXTRA_EMAIL,new String []{"atendimento@atmconsultoria.pt"});
            intent.putExtra(Intent.EXTRA_SUBJECT,"Contato pelo App");
            intent.putExtra(Intent.EXTRA_TEXT,"Mensagem automática");

            intent.setType("mensagem/rfc822");
           // intent.setType("text/plain");
            // intent.setType("image/*");
           // intent.setType("application/pdf");


            startActivity(Intent.createChooser(intent,"Escolha um app de email"));
        }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}