package com.example.ti.novocasual;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ti on 04/11/16.
 */

public class AdaptadorDeUsuarios extends RecyclerView.Adapter<AdaptadorDeUsuarios.MeuViewHolder>{

    private List<Usuario> mList;
    private LayoutInflater mLayoutInflater;

    public AdaptadorDeUsuarios(Context c, List<Usuario>l) {
        mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mList = l;
    }

    // este metodo eh chamado somente quando há nessecidade de criar
    @Override
    public MeuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.item_usuario,parent,false);
        MeuViewHolder mvh = new MeuViewHolder(v);
        return mvh;
    }
    // este metodo eh chamado toda hora, ele eh quem vincula os dados da nossa lista a View,
    // mesmo que seje uma View que está sendo reutilizada.
    @Override
    public void onBindViewHolder(MeuViewHolder holder, int position) {
        //holder.mFoto.setImageResource(mlista.get(position).getFoto());
        holder.mFoto.setImageResource(R.drawable.ictest);
        holder.mPessoaNome.setText(mList.get(position).getNome());
        holder.mPessoaEmail.setText(mList.get(position).getEmail());
    }
    // este metodo retorna o tamanho da lista
    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void addListItem(Usuario u, int posicao) {
        mList.add(u);
        notifyItemInserted(posicao);
    }

    // classe responssavel por gerenciar o layout da lista
    public class MeuViewHolder extends RecyclerView.ViewHolder{

        private ImageView mFoto;
        private TextView mPessoaNome;
        private TextView mPessoaEmail;

        public MeuViewHolder(View itemView) {
            super(itemView);
            mFoto = (ImageView) itemView.findViewById(R.id.ID_foto);
            mPessoaNome = (TextView) itemView.findViewById(R.id.ID_pessoa_nome);
            mPessoaEmail= (TextView) itemView.findViewById(R.id.ID_pessoa_email);
        }
    }
}
