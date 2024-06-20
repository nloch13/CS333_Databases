
SELECT *
FROM Supplier 
;

SELECT *
FROM Parts 
;

SELECT * 
FROM Shipment
;

SELECT DISTINCT PName
FROM Parts
;

SELECT AVG(Qty)
FROM Shipment
;


SELECT *
FROM Parts
WHERE Color = 'Red'
;



SELECT Shippment.SNUM, COUNT(Shipment.SNUM) AS NumShipments
FROM Shipments
GROUP BY Shipments.SNUM
;

SELECT Parts.COLOR, COUNT(Parts.PNUM) AS NumPartsByColor
FROM Parts
GROUP BY Parts.Color
;