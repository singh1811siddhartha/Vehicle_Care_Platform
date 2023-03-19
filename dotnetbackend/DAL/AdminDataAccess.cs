namespace dotnetbackend.DAL;

    using dotnetbackend.Model;
    using MySql.Data.MySqlClient;
    using System;
    using System.Collections.Generic;
    using System.Data;

    public class AdminDataAccess
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

    public List<Admin> GetAllAdmin()
        {
            List<Admin> alladmin = new List<Admin>();
            using (MySqlConnection connection = new MySqlConnection(conString))
            {
                string query = "SELECT * FROM admin";
                using (MySqlCommand command = new MySqlCommand(query, connection))
                {
                    try
                    {
                        connection.Open();
                        using (MySqlDataReader reader = command.ExecuteReader())
                        {   
                            
                            while (reader.Read())
                            {
                                Admin admin = new Admin(id, name, email, password, contactno, age, createDate, address, location, gender)
                                {
                                    Id = Convert.ToInt64(reader["admin_id"]),
                                    Name = reader["admin_name"].ToString(),
                                    Email = reader["email"].ToString(),
                                    Password = reader["password"].ToString(),
                                    Contactno = reader["contactno"].ToString(),
                                    Age = Convert.ToInt64(reader["age"]),
                                    CreateDate = Convert.ToDateTime(reader["created_at"]),
                                    Address = reader["address"].ToString(),
                                    Location = reader["location"].ToString(),
                                    Gender = reader["gender"].ToString()
                                };
                                alladmin.Add(admin );
                            }
                        }
                    }
                    catch (Exception e)
                    {
                        Console.WriteLine(e.Message);
                    }
                }
            }
            return alladmin;
        }

        public void SaveNewAdmin(Admin admin)
        {
            using (MySqlConnection connection = new MySqlConnection(conString))
            {
                string query = $"INSERT INTO admin(admin_name, email, password, contactno, age, created_at, address, location, gender) VALUES('{admin.Name}', '{admin.Email}', '{admin.Password}', '{admin.Contactno}', {admin.Age}, '{admin.CreateDate:yyyy-MM-dd HH:mm:ss}', '{admin.Address}', '{admin.Location}', '{admin.Gender}')";
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

        public void DeleteAdminById(long id)
        {
            using (MySqlConnection connection = new MySqlConnection(conString))
            {
                string query = $"DELETE FROM admin WHERE admin_id = {id}";
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

        public void UpdateAdmin(Admin admin)
        {
            using (MySqlConnection connection = new MySqlConnection(conString))
            {
                string query = $"UPDATE admin SET admin_name='{admin.Name}', email='{admin.Email}', password='{admin.Password}', contactno='{admin.Contactno}', age={admin.Age}, created_at='{admin.CreateDate:yyyy-MM-dd HH:mm:ss}', address='{admin.Address}', location='{admin.Location}', gender='{admin.Gender}' WHERE admin_id={admin.Id}";
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

