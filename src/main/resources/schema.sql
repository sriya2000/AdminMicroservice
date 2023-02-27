CREATE TABLE `Catalog` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `catalogName` varchar(255),
  `description` varchar(255),
  `imageUrl` varchar(255)
);

CREATE TABLE `products` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255),
  `description` varchar(255),
  `imageUrl` varchar(255),
  `price` double,
  `catalog_id` int
);

CREATE TABLE `users` (
  `id` int PRIMARY KEY,
  `firstName` varchar(255),
  `lastName` varchar(255),
  `email` varchar(255),
  `password` varchar(255),
  `phoneNumber` varchar(255),
  `address` varchar(255)
);

CREATE TABLE `Cart` (
  `id` int PRIMARY KEY,
  `createdDate` Date,
  `product_id` int,
  `product_price` int,
  `quantity` int,
  `total_cost` double,
  `uid` int,
  `product_name` varchar(255),
  `shippingAddress` varchar(255)
);

CREATE TABLE `TransactionMode` (
  `id` int PRIMARY KEY,
  `transactionType` varchar(255)
);

CREATE TABLE `Transaction` (
  `id` int PRIMARY KEY,
  `uId` int,
  `transactionModeId` int,
  `totalAmount` double,
  `dateTime` Date
);

CREATE TABLE `OrderDetails` (
  `id` int PRIMARY KEY,
  `customerId` int,
  `transactionId` int,
  `productId` int,
  `quantity` int,
  `dateTime` Date
);

ALTER TABLE `products` ADD FOREIGN KEY (`catalog_id`) REFERENCES `Catalog` (`id`);

ALTER TABLE `Transaction` ADD FOREIGN KEY (`transactionModeId`) REFERENCES `TransactionMode` (`id`);

ALTER TABLE `Transaction` ADD FOREIGN KEY (`id`) REFERENCES `OrderDetails` (`transactionId`);

ALTER TABLE `Cart` ADD FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

ALTER TABLE `Cart` ADD FOREIGN KEY (`uid`) REFERENCES `users` (`id`);

ALTER TABLE `Transaction` ADD FOREIGN KEY (`uId`) REFERENCES `users` (`id`);

ALTER TABLE `OrderDetails` ADD FOREIGN KEY (`customerId`) REFERENCES `users` (`id`);

ALTER TABLE `OrderDetails` ADD FOREIGN KEY (`productId`) REFERENCES `products` (`id`);
