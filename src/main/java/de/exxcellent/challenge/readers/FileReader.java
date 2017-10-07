package de.exxcellent.challenge.readers;

import de.exxcellent.challenge.model.*;
import java.util.*;

//Interface for file reading classes
public interface FileReader{
	Database readData(String fileName);
}