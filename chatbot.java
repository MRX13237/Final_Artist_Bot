import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class chatbot extends JFrame {
    
private JTextArea chatArea;
private JTextField userInputField;
private JButton sendButton;

public chatbot() {
setTitle("Artistbot");
setSize(400, 500);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(new BorderLayout());

// Chat area
chatArea = new JTextArea();
chatArea.setEditable(false);
chatArea.setLineWrap(true);
chatArea.setWrapStyleWord(true);
JScrollPane scrollPane = new JScrollPane(chatArea);
add(scrollPane, BorderLayout.CENTER);

// User input panel
JPanel inputPanel = new JPanel();
userInputField = new JTextField(25);
sendButton = new JButton("Send");

inputPanel.add(userInputField);
inputPanel.add(sendButton);

// Toggle button
JToggleButton toggleButton = new JToggleButton("Chat On/Off");
toggleButton.setSelected(true); // Initially selected
inputPanel.add(toggleButton);

add(inputPanel, BorderLayout.SOUTH);

// Action listener for the send button
sendButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
String userInput = userInputField.getText();
if (!userInput.isEmpty() && toggleButton.isSelected()) { // Check toggle state
chatArea.append("You: " + userInput + "\n");
String botResponse = getBotResponse(userInput);
chatArea.append("Bot: " + botResponse + "\n");
userInputField.setText("");
}
}
});
}

// Method to generate bot responses based on user input
private String getBotResponse(String input) {
input = input.toLowerCase();

if (input.contains("hello") || input.contains("hi")) {
return "Hello! How can I assist you today?";
} else if (input.contains("how are you")) {
return "I'm just a program, but thanks for asking!";
} else if (input.contains("bye")) {
return "Goodbye! Have a great day!";
} else {
return "Sorry, I didn't understand that.";
}
}

public static void main(String[] args) {
SwingUtilities.invokeLater(() -> {
chatbot chatbot = new chatbot();
chatbot.setVisible(true);
});
}
}