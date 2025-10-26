# 🏃‍♂️ Marathon Simulator – JavaFX MVC Application
Students are encouraged to explore additional features and demonstrate strong problem-solving skills as well as effective GUI design.
## What to Do

Implement an **MVC-based JavaFX GUI application** for a **Marathon Simulator** that simulates a marathon race.

## Application Requirements

### 1. Display a Slideshow of Marathoners

- The application should begin by displaying a **slideshow of 4 to 5 marathoners** along with a **greeting message**.

- Use **JavaFX multimedia features** such as playing a **sound file** during the slideshow.

- Each marathoner should have a **unique identity and appearance** (name, number, color, etc.).

- You can **design and draw** the marathoners using tools such as Photoshop, Paint, or any drawing application.

- The slideshow should:

  - Display **one marathoner’s picture at a time**.

  - Use **appropriate colors, shapes, and sizes**.

  - Have a **reasonable delay** between images.

  - Automatically display the **next marathoner’s picture** after the delay.

### 2. Display the Marathon Simulation

After the slideshow, the **marathon simulation** should start.

- The UI should include a layout similar to the example provided (a race track, marathoners, and control buttons).

- Use the **Transition class** in JavaFX to animate each marathoner’s movement from the **start line** to the **finish line**.

- Each marathoner’s animation should simulate motion by changing shape attributes (e.g., position) over time.

- The **winner** is the first marathoner to cross the finish line.

When the race ends:

- Display an **appropriate message** announcing the winner(s).

- Update the **message area** (bottom right) with relevant information, such as:

  - Greeting messages

  - Race results

  - Types of animations demonstrated

  - Layout or interface details

### 3. Control Buttons

In the **bottom-left area**, provide control buttons for managing the simulation:

| Button | Description |

| **Start** | Starts or resumes the marathon simulation. |

| **Pause** | Pauses the ongoing simulation. |

| **Exit** | Closes the application. |

You may add additional buttons or controls as needed.

##  MVC Architecture Requirements

Implement the application using the **Model–View–Controller (MVC)** pattern:

### **Model – MarathonerModel**

- Stores data and attributes for each marathoner, such as:

  - Name

  - Number

  - Coordinates (x, y)

  - Speed

  - Color

- Provides methods for updating state and position.

### **Controller – MarathonController**

- Manages the **simulation logic**.

- Handles actions such as:

  - Starting and stopping the race

  - Updating marathoner positions

  - Determining and displaying the winner(s)

### **View – MarathonerFXML (or equivalent JavaFX View class)**

- Responsible for the **graphical user interface** and **visual representation**.

- Displays:

  - The slideshow

  - The race simulation

  - Messages (greeting, race results, animations, layout info, etc.)

## Notes

- Use **JavaFX graphics and multimedia features** creatively for colors, shapes, and animations.

- Ensure all marathoners are **uniquely identified** and **visually distinct**.

- The MVC design ensures **modularity**, **maintainability**, and **clean code organization**.

**End of Requirements**
