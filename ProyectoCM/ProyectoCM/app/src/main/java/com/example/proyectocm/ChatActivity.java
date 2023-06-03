package com.example.proyectocm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.ktx.Firebase;


public class ChatActivity extends AppCompatActivity {/*
    private String chatId = "";
    private String user = "";

    private Fire

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        chatId = getIntent().getStringExtra("chatId");
        user = getIntent().getStringExtra("user");

        if (!chatId.isEmpty() && !user.isEmpty()) {
            initViews();
        }
    }

    private void initViews() {
        RecyclerView messagesRecyclerView = findViewById(R.id.messagesRecylerView);
        messagesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        MessageAdapter messageAdapter = new MessageAdapter(user);
        messagesRecyclerView.setAdapter(messageAdapter);

        Button sendMessageButton = findViewById(R.id.sendMessageButton);
        sendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });

        CollectionReference chatRef = db.collection("chats").document(chatId).collection("messages");

        chatRef.orderBy("dob", Query.Direction.ASCENDING).get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<Message> listMessages = queryDocumentSnapshots.toObjects(Message.class);
                        messageAdapter.setData(listMessages);
                    }
                });

        chatRef.orderBy("dob", Query.Direction.ASCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot queryDocumentSnapshots, FirebaseFirestoreException error) {
                if (error == null) {
                    List<Message> listMessages = queryDocumentSnapshots.toObjects(Message.class);
                    messageAdapter.setData(listMessages);
                }
            }
        });
    }

    private void sendMessage() {
        EditText messageTextField = findViewById(R.id.messageTextField);
        String messageText = messageTextField.getText().toString();

        Message message = new Message(messageText, user);

        db.collection("chats").document(chatId).collection("messages").add(message);

        messageTextField.setText("");
    }*/
}