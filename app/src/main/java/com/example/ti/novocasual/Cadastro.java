package com.example.ti.novocasual;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Cadastro extends AppCompatActivity {

    private EditText email, senha;
    private Button btnSignIn, btnSignUp, btnResetPassword;
    private ProgressBar progressBar;
    private FirebaseAuth auth;
    private DatabaseReference databaseReference,banco,banco1,refBanco,banco2;
    //private DatabaseReference banco;
    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        banco = databaseReference.child("brasil");
        //Obter instância Firebase auth
        auth = FirebaseAuth.getInstance();

        btnSignIn = (Button) findViewById(R.id.sign_in_button);
        btnSignUp = (Button) findViewById(R.id.sign_up_button);
        email = (EditText) findViewById(R.id.ID_email);
        senha = (EditText) findViewById(R.id.ID_password);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        btnResetPassword = (Button) findViewById(R.id.btn_reset_password);

        ////////////////////////////////////////////////////////////////////////////////////////////

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String emailLocal = email.getText().toString().trim();
                final String senhaLocal = senha.getText().toString().trim();

                if (TextUtils.isEmpty(emailLocal)) {
                    Toast.makeText(getApplicationContext(), "Insira o endereço de Email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(senhaLocal)) {
                    Toast.makeText(getApplicationContext(), "Insira a Senha!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (senhaLocal.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Senha muito curta, insira no minimo 6 caracteres!", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                //cria usuário
                auth.createUserWithEmailAndPassword(emailLocal, senhaLocal)
                        .addOnCompleteListener(Cadastro.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(Cadastro.this, "Cria Usuário com Email: " + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);
                                // Se a assinatura falhar, exibir uma mensagem ao usuário.
                                // Se a assinatura for bem sucedida será mostrado uma
                                // notificação com o estado deste metodo auth e a lógica
                                // para lidar com o usuario conectado pode ser tratado neste Listener.
                                if (!task.isSuccessful()) {
                                    Toast.makeText(Cadastro.this, "Autentificação falhou." + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    //usuario.setId(auth.getCurrentUser().getUid().toString());
                                    //usuario.saveDB();
                                    //auth.signOut();
                                    //
                                    usuario = new Usuario();

                                    //usuario.setEmail(email.getText().toString().trim());
                                    //usuario.setSenha(senha.getText().toString().trim());

                                    usuario.setEmail(emailLocal);
                                    usuario.setSenha(senhaLocal);
                                    usuario.setNome("nome1");
                                    usuario.setId(auth.getCurrentUser().getUid().toString());
                                    usuario.setOnline("false");
                                    usuario.setLat("-30.1611991");
                                    usuario.setLng("-51.1399591");
                                    //banco.child(usuario.getId());
                                    //banco.child("ID");
                                    //banco.setValue(usuario);
                                    banco1=banco.child("RioGrandeDoSul");
                                    banco2=banco1.child(usuario.getId());
                                    refBanco=banco2.child("usuario");
                                    //refBanco=banco.child("RioGrandeDoSul").child("usuarios");
                                    refBanco.setValue(usuario);
                                    usuario = new Usuario();
                                    Toast.makeText(getBaseContext(),"Usuario Criado com Sucesso !!!",Toast.LENGTH_SHORT).show();
                                    //startActivity(new Intent(Cadastro.this, Login.class));
                                    finish();
                                }
                            }
                        });

            }
        });
////////////////////////////////////////////////////////////////////////////////////////////////////
    }
    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }
}
