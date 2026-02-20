# 🤖 Doraemon - Your Personal Schedule Assistant! 

Hey there! 👋 Meet Doraemon - your super cute and friendly schedule assistant! ✨ Built with JavaFX, this little blue robot cat is here to help you stay organized and never miss a deadline! 🎯

![Doraemon](https://img.shields.io/badge/Java-17-orange) ![JavaFX](https://img.shields.io/badge/JavaFX-17.0.7-blue)

## 🌟 What Can Doraemon Do?

- ✅ **Task Management**: Add, delete, mark, and unmark tasks like a pro!
- 📝 **Multiple Task Types**: Todo, Deadline, and Event tasks - we've got you covered!
- 🔍 **Smart Search**: Find your tasks super quickly with keyword search and Retrieve tasks with certain priority!
- 🎨 **Beautiful GUI**: Gorgeous gradient backgrounds and smooth animations that'll make you smile 😊
- 💾 **Auto-Save**: Your tasks are automatically saved - no worries about losing anything!

## 🚀 Quick Start

### What You'll Need

- ☕ JDK 17 or higher
- 🎭 JavaFX 17.0.7

### Let's Get Started! 

1. 📥 Clone this repository
2. 💻 Open it up in IntelliJ IDEA
3. ⚙️ Make sure you're using JDK 17
4. ▶️ Run `Main.java` or just type:
   ```bash
   ./gradlew run
   ```

That's it! You're ready to go! 🎉

## 💬 How to Use

### Commands You Can Use
- **`hi`** 🥳 - See all possible commands and features
- **`list`** 📋 - See all your tasks at once!
- **`todo <description> [priority]`** ➕ - Add a simple todo task
- **`deadline <description> / <date> [priority]`** ⏰ - Add a deadline (date format: YYYY-MM-DD)
- **`event <description> / <start> / <end> [priority]`** 📅 - Add an event with start and end dates
- **`mark <index>`** ✅ - Mark a task as done (feels so good!)
- **`unmark <index>`** 🔄 - Oops, need to unmark? No problem!
- **`delete <index>`** 🗑️ - Remove a task you don't need anymore
- **`priority <level>`** 〽️ - Retrieve tasks with certain priority (1 highest, 3 lowest)
- **`find <keyword>`** 🔍 - Search for tasks by keyword
- **`bye`** 👋 - Say goodbye to Doraemon (he'll remember everything!)

### Example Time! 🎯

```
hi
todo read book 📖
deadline assignment1 / 2026-02-05 [1]📝
event lab2 / 2026-02-19 / 2026-03-01 [2] 🧪
mark 1 ✨
find book 🔎
priority 1 〽️
list 📋
bye 👋
```

## 🎨 Cool Features

### Welcome Message 💬
When you first open the app, Doraemon will greet you with:
> *"Hi I am Doraemon, your personal schedule assistant! Welcome to tell me anything!"*

So friendly, right? 😊

### Task Types 🏷️
- **[T]** 📝 - Todo tasks (simple stuff!)
- **[D]** ⏰ - Deadline tasks (with due dates!)
- **[E]** 📅 - Event tasks (with start and end dates!)

### The Interface 🎨
- 🌈 **Beautiful Gradients**: Soft blue-to-green backgrounds that are easy on the eyes
- 💬 **Chat Style**: Messages in cute colorful bubbles
- 📱 **Responsive**: Works great when you resize the window
- 🔄 **Auto-Scroll**: Always shows the latest messages automatically

## 📁 Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── seedu/doraemon/
│   │       ├── Main.java          # Where it all starts! 🚀
│   │       ├── Doraemon.java      # The brain of the operation 🧠
│   │       ├── Parser.java        # Understands what you're saying 💭
│   │       ├── TaskList.java      # Keeps track of everything 📋
│   │       ├── Storage.java       # Saves your stuff 💾
│   │       └── commands/          # All the cool commands ⚡
│   └── resources/
│       ├── view/                  # The pretty UI layouts 🎨
│       └── css/                   # Making it look amazing ✨
└── test/                          # Making sure everything works 🧪
```

## 🛠️ Built With

- ☕ **Java 17** - The programming language
- 🎭 **JavaFX 17.0.7** - For that beautiful GUI
- 🔧 **Gradle** - Building everything smoothly
- 🧪 **JUnit 5** - Testing to make sure it works perfectly

## 📜 License

This is a project for a software engineering course! 📚

## 🙏 Acknowledgments

Inspired by the amazing Doraemon from the classic Japanese manga and anime! 🤖✨

---

Made with ❤️ and lots of ☕ by someone who loves staying organized!
