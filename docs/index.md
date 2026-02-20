# 🤖 Doraemon User Guide

Welcome to Doraemon! Your friendly personal schedule assistant! 🎯

## 🚀 Quick Start

1. Run the application (use `./gradlew run` or run `Main.java`)
2. Type commands in the text field at the bottom
3. Press Enter or click "Send" ✨

## 💬 Commands

### View all Commands
- **`hi`** 📋 - Show all commands and how to use them
### View Tasks
- **`list`** 📋 - Show all your tasks

### Add Tasks
- **`todo <description> [priority]`**- Add a todo task
  - Example: `todo buy groceries [1]` (highest priority)
  
- **`deadline <description> / <date> [priority]`**  - Add a deadline (date: YYYY-MM-DD)
  - Example: `deadline finish project / 2026-02-20 [2]` (medium priority)
  
- **`event <description> / <start> / <end> [priority]`**  - Add an event (dates: YYYY-MM-DD)
  - Example: `event conference / 2026-03-01 / 2026-03-03 [3]` (lowest priority)

### Manage Tasks
- **`mark <index>`** ✅ - Mark task as done
  - Example: `mark 1`
  
- **`unmark <index>`** 🔄 - Mark task as not done
  - Example: `unmark 1`
  
- **`delete <index>`** 🗑️ - Delete a task
  - Example: `delete 2`

### Retrieve Tasks for certain priority
- ** `priority 1`** - Retrieve tasks that have the highest priority
- ** `priority 2`** - Retrieve tasks that have medium priority
- ** `priority 3`** - Retrieve tasks that have the lowest priority
### Search
- **`find <keyword>`** 🔍 - Find tasks with keyword
  - Example: `find book`

### Exit
- **`bye`** 👋 - Exit the app

## 📝 Task Types

- **[T]** 📝 - Todo (no date)
- **[D]** ⏰ - Deadline (has due date)
- **[E]** 📅 - Event (has start and end dates)

**Status:**
- **[ ]** - Not done
- **[X]** - Done ✅

## 💡 Quick Tips

- Use `list` to see all tasks and their numbers
- Date format: YYYY-MM-DD (e.g., 2026-02-19)
- Commands work in any case (LIST, list, List)
- Your tasks are auto-saved! 💾

Need help? Just ask Doraemon! 🤖✨
