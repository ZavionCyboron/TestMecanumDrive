package frc.robot

import com.pathplanner.lib.auto.AutoBuilder
import com.pathplanner.lib.config.PIDConstants
import com.pathplanner.lib.auto.NamedCommands
import com.pathplanner.lib.config.RobotConfig
import com.pathplanner.lib.controllers.PPHolonomicDriveController
import edu.wpi.first.wpilibj.DriverStation
import edu.wpi.first.wpilibj.XboxController
import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import edu.wpi.first.wpilibj2.command.Command
import edu.wpi.first.wpilibj2.command.InstantCommand
import subsystems.DriveSubsystem
import subsystems.DriveSubsystem.mecanumDrive
import subsystems.DriveSubsystem.driverelative
import org.photonvision.PhotonCamera
import subsystems.DriveSubsystem.pose

object RobotContainer {

    private val stick: Joystick = Joystick(0)

    private var autoChooser: SendableChooser<Command>? = null

    val autonomousCommand: Command
        get() {
            return autoChooser?.selected ?: InstantCommand()
        }

    init {
        configureBindings()
        cameraSettings()
    }

    //private val  controller: XboxController = XboxController(0)


    private fun configureBindings() {

        DriveSubsystem.defaultCommand =
            DriveSubsystem.run {
                mecanumDrive(stick.getY(), -stick.getX(), -stick.getZ())
            }
    }

    private fun cameraSettings() {

    }
}