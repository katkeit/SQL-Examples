# SQL-Examples
A Java project containing examples for connecting to a database, running stored procedures, triggers, and etc.

## ❈ Requirements
- Java Development Kit 14
- MySQL Community Server 8
- Java IDE (ex. Eclipse or IntelliJ IDEA Community)

## ❈ Download and Install
### ∎ Java Development Kit 14
1) Download and install <a href = "https://www.oracle.com/java/technologies/javase-jdk14-downloads.html">JDK 14</a>.


### ∎ MySQL Community Server 8
 1) Download <a href = "https://dev.mysql.com/downloads/">MySQL Community Server 8</a>/
 <br><b>NOTE:</b> For Windows, click on 'MySQL Installer for Windows', otherwise, click on 'MySQL Community Server'.
 
 2) Install MySQL Community. Please follow this <a href = "https://dev.mysql.com/doc/mysql-getting-started/en/#mysql-getting-started-installing">installation guide</a> for help.
 
 ## ❈ Setting up and Configuring
 ### ∎ Importing to Eclipse
1) Open Eclipse IDE.
2) Click File in the toolbar at the top.
3) Click Import...
4) In the pop-up, click the Git folder in the center section.
5) Click Projects from Git (with smart import).
6) Click Next at bottom of the current window.
7) Click Clone URI and click Next
8) Paste "<https://github.com/katkeit/SQL-Examples>" into URI section and click Next.
<br><b>NOTE:</b> The window will fill out some sections automatically.

9) Click Next.
10) Ensure the directory path is where you want the project to store. Click Next.
11) Click Finish.

### ∎ Importing to IntelliJ IDEA Community
1) Open IntelliJ IDEA Community.
<br><b>NOTE:</b> If any existing projects are open, click File in the toolbar at the top, and click Close Project.

2) On the right-hand side of the IntelliJ IDEA launcher click "Get from Version Control".
<br><b>NOTE:</b> This window will automatically appear if all currently opened projects are closed.

3) On the left side of the window make sure Repository URL is selected.
4) In the center, copy and paste "<https://github.com/katkeit/SQL-Examples>" into the URL box.
5) Confirm where you want the files to clone to in the Directory box.
6) Click Clone at the bottom.

### ■ Configuring IntelliJ IDEA Community
#### ▶ Selecting Project SDK
1) With the project open, go to File, and click 'Project Structure...'.

2) In the Project Structure window, and click the Project tab inside the Project Settings section on the left.

3) In the middle section of the window, under the Project SDK section, click the drop down menu, and select 'java version 14'.

4) Click the OK button at the bottom of the window.

### ∎ Configuring MySQL Community Server 8
1) Open MySQL Workbench 8
<br><b>NOTE:</b> For users using command line, please follow this <a href = "https://phoenixnap.com/kb/how-to-backup-restore-a-mysql-database">guide</a> to restore the database.

2) Double-click on your 'Local instance MySQL80' and enter your root password. The root password would have been created during installation.
<br><b>NOTE:</b> To reset your root password on Windows, follow this <a href = "https://dev.mysql.com/doc/mysql-windows-excerpt/8.0/en/resetting-permissions-windows.html">guide</a>. For Linux users, please follow this <a href = "https://tecadmin.net/how-to-recover-mysql-root-password/">guide</a>.

3) In the Navigator window, click the Administrator tab at the bottom of the window, and click 'Data Import/Restore'.

4) In the 'Import Options' section, select 'Import from Self-Contained File', and browse for the 'sunonline_v1006.sql' file.
<br><b>NOTE:</b> You need to download the sunonline_v1006.sql file from the Download section below.

5) In the 'Default Schema to be Imported To' section, click 'New...' button, and type in 'sunonline_v1006', and click 'OK'.

6) At the bottom, click 'Start Import' button.
<br><b>NOTE:</b> Once the import is complete, then you can close the tab.

7) In the Navigator menu, click the Schemas tab at the bottom, click the refresh button near the top, and 'sunonline_v1006' database should appear.
