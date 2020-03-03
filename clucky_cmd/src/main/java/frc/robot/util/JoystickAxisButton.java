// Use this the same way you would use JoystickButton (which is documented by in wpilib)

package frc.robot.util;

import edu.wpi.first.wpilibj.Joystick;

public class JoystickAxisButton {
  // declare the joystick used as well as the axis numner
  private final Joystick m_joystick;
  private final int m_axisNumber;
  // set the threshold needed to cross to be considered a button press
  private final double m_threshold;

  public JoystickAxisButton(Joystick joystick, int axisNumber, double threshold) {
    m_joystick = joystick;
    m_axisNumber = axisNumber;
    m_threshold = threshold;
  }

  public boolean get() {
    if (m_threshold < 0) {
      return m_joystick.getRawAxis(m_axisNumber) > m_threshold;
    } else {
      return m_joystick.getRawAxis(m_axisNumber) > m_threshold;
    }
  }
}