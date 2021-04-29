package com.example.consultoria.ui.sobre;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.consultoria.R;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class SobreFragment extends Fragment {



    public SobreFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        String descricao ="A ATM consultorio tem como missão apoiar" +
                "que desejam alcançar o sucesso atráves da exelência " +
                "em gestão e da busca pela qualidade.";

        Element versao = new Element();
        versao.setTitle("Versão 1.0");

       return new AboutPage(getActivity())
                .setImage(R.drawable.logo)
               .setDescription(descricao)

                .addGroup("Entre em Contacto")
                .addEmail("atendimento@atmconsultorio.pt", "Envie um email")
                .addWebsite("https://www.google.com/","Acesse o nosso site")

                .addGroup("Redes Sociais")
                .addFacebook("vircagbonfim", "Facebook")
                .addInstagram("vircagoncalves","Intragram")
                .addTwitter("vircagbonfim", "Facebook")
                .addYoutube("vircagonçalves", "Youtube")
                .addGitHub("vircag", "GitHub")
                .addPlayStore("com.facebook.katana", "Download App")
                .addFacebook("vircagbonfim", "Facebook")



               .addItem(versao)
                .create();


        //return inflater.inflate(R.layout.fragment_sobre, container, false);
    }
}