namespace AndroidCA
{
    using System;
    using System.Data.Entity;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Linq;

    public partial class ItemModel : DbContext
    {
        public ItemModel()
            : base("name=ItemModel")
        {
        }

        public virtual DbSet<Item> Items { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Item>()
                .Property(e => e.price)
                .HasPrecision(18, 0);

            modelBuilder.Entity<Item>()
                .Property(e => e.category)
                .IsFixedLength();

            modelBuilder.Entity<Item>()
                .Property(e => e.seller)
                .IsFixedLength();
        }
    }
}
