package com.example.proyectocm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


import com.example.proyectocm.model.Chat;
import com.google.firebase.ktx.Firebase;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class ListaChatsActivity extends AppCompatActivity {/*

    private String usuario;
    private Button nuevoChat;

    private Firebase db ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_chats);

        usuario = getIntent().getStringExtra("usuario");

        nuevoChat = findViewById(R.id.nuevoChat);

        if (usuario != null) {
            if (!usuario.isEmpty()) {
                initViews();
            }
        }
    }

    private void initViews() {
        nuevoChat.setOnClickListener(v -> newChat());

        listaChatsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        listChatsRecyclerView.setAdapter(new ChatAdapter(chat -> chatSelected(chat)));

        DocumentReference userRef = db.collection("users").document(user);

        userRef.collection("chats")
                .get()
                .addOnSuccessListener(chats -> {
                    List<Chat> listChats = chats.toObjects(Chat.class);
                    ((ChatAdapter) listChatsRecyclerView.getAdapter()).setData(listChats);
                });

        userRef.collection("chats")
                .addSnapshotListener((chats, error) -> {
                    if (error == null) {
                        if (chats != null) {
                            List<Chat> listChats = chats.toObjects(Chat.class);
                            ((ChatAdapter) listChatsRecyclerView.getAdapter()).setData(listChats);
                        }
                    }
                });
    }
    private void newChat() {
        String chatId = UUID.randomUUID().toString();
        String otherUser = newChatText.getText().toString();
        List<String> users = Arrays.asList(user, otherUser);

        Chat chat = new Chat(chatId, "Chat con " + otherUser, users);

        db.collection("chats").document(chatId).set(chat);
        db.collection("users").document(user).collection("chats").document(chatId).set(chat);
        db.collection("users").document(otherUser).collection("chats").document(chatId).set(chat);

        Intent intent = new Intent(this, ChatActivity.class);
        intent.putExtra("chatId", chatId);
        intent.putExtra("user", user);
        startActivity(intent);
    }*/

}