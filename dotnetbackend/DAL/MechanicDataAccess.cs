namespace dotnetbackend.DAL;

    using dotnetbackend.Model;
    using MySql.Data.MySqlClient;
    using System;
    using System.Collections.Generic;
    using System.Data;

    public class MechanicDataAccess
    {
        public static string conString = @"server=localhost; port=3306; user=root; password=1811@sid; database=vehicle_care_platform";
    private long id;
    private string? name;
    private string? email;
    private string? password;
    private string? contactno;
    private long age;
    private DateTime createDate;
    private string? address;
    private string? location;
    private string? gender;

    public List<Mechanic> GetAllMechanics()
        {
            List<Mechanic> allMechs = new List<Mechanic>();
            using (MySqlConnection connection = new MySqlConnection(conString))
            {
                string query = "SELECT * FROM mechanic";
                using (MySqlCommand command = new MySqlCommand(query, connection))
                {
                    try
                    {
                        connection.Open();
                        using (MySqlDataReader reader = command.ExecuteReader())
                        {   
                            
                            while (reader.Read())
                            {
                                Mechanic mech = new Mechanic(id, name, email, password, contactno, age, createDate, address, location, gender)
                                {
                                    Id = Convert.ToInt64(reader["mechanic_id"]),
                                    Name = reader["mechanic_name"].ToString(),
                                    Email = reader["email"].ToString(),
                                    Password = reader["password"].ToString(),
                                    Contactno = reader["contactno"].ToString(),
                                    Age = Convert.ToInt64(reader["age"]),
                                    CreateDate = Convert.ToDateTime(reader["created_at"]),
                                    Address = reader["address"].ToString(),
                                    Location = reader["location"].ToString(),
                                    Gender = reader["gender"].ToString()
                                };
                                allMechs.Add(mech );
                            }
                        }
                    }
                    catch (Exception e)
                    {
                        Console.WriteLine(e.Message);
                    }
                }
            }
            return allMechs;
        }

        public void SaveNewMechanic(Mechanic mech)
        {
            using (MySqlConnection connection = new MySqlConnection(conString))
            {
                string query = $"INSERT INTO mechanic(mechanic_name, email, password, contactno, age, created_at, address, location, gender) VALUES('{mech.Name}', '{mech.Email}', '{mech.Password}', '{mech.Contactno}', {mech.Age}, '{mech.CreateDate:yyyy-MM-dd HH:mm:ss}', '{mech.Address}', '{mech.Location}', '{mech.Gender}')";
                using (MySqlCommand command = new MySqlCommand(query, connection))
                {
                    try
                    {
                        connection.Open();
                        command.ExecuteNonQuery();
                    }
                    catch (Exception e)
                    {
                        Console.WriteLine(e.Message);
                    }
                }
            }
        }

        public void DeleteMechById(long id)
        {
            using (MySqlConnection connection = new MySqlConnection(conString))
            {
                string query = $"DELETE FROM mechanic WHERE mechanic_id = {id}";
                using (MySqlCommand command = new MySqlCommand(query, connection))
                {
                    try
                    {
                        connection.Open();
                        command.ExecuteNonQuery();
                    }
                    catch (Exception e)
                    {
                        Console.WriteLine(e.Message);
                    }
                }
            }
        }

        public void UpdateMechanic(Mechanic mech)
        {
            using (MySqlConnection connection = new MySqlConnection(conString))
            {
                string query = $"UPDATE mechanic SET mechanic_name='{mech.Name}', email='{mech.Email}', password='{mech.Password}', contactno='{mech.Contactno}', age={mech.Age}, created_at='{mech.CreateDate:yyyy-MM-dd HH:mm:ss}', address='{mech.Address}', location='{mech.Location}', gender='{mech.Gender}' WHERE mechanic_id={mech.Id}";
                using (MySqlCommand command = new MySqlCommand(query, connection))
                {
                    try
                    {
                        connection.Open();
                        command.ExecuteNonQuery();
                    }
                    catch (Exception e)
                    {
                        Console.WriteLine(e.Message);
                    }
                }
            }
        }
    }

