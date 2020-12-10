<?
$user="frogger";
$password="horseshoe";
$database="MySQL57";
mysql_connect(localhost,$user,$password);
@mysql_select_db($database) or die("Unable to select database");
$query="CREATE TABLE contacts (id int(6) NOT NULL auto_increment, first_name varchar(20) NOT NULL, last_name varchar(30) NOT NULL, PRIMARY KEY (id), UNIQUE id(id),KEY id_2(id))";
mysql_query($query);
mysql_close();
?>