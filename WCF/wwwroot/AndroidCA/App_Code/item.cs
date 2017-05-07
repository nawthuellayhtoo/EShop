namespace AndroidCA
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("item")]
    public partial class Item
    {
        [Key]
        [Column(Order = 0)]
        public int id { get; set; }

        [Key]
        [Column(Order = 1)]
        [StringLength(50)]
        public string name { get; set; }

        [StringLength(50)]
        public string description { get; set; }

        public decimal price { get; set; }

        [Key]
        [Column(Order = 2)]
        [StringLength(50)]
        public string status { get; set; }

        [Key]
        [Column(Order = 3)]
        [StringLength(50)]
        public string category { get; set; }

        [Key]
        [Column(Order = 4)]
        [StringLength(50)]
        public string seller { get; set; }
    }
}
