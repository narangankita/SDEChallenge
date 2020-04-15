
**1. Coding Question**

**Solution**

The code for the question can be found in the "src" folder.

Additional explanation about the interface and implementation : Interface : com.paytmlabs.sdechallenge.MovingAverage.java
This interface declares 3 methods to solve the question:
1. calculateMovingAverage - to calculate the moving average of last N numbers
2. addElement(T element) - to add element to the data structure
3. getElements() - to access all the elements added.

This interface is created as a generic type where the implementation class can decide about the type of elements in wants to use and operate on.

Implementation : com.paytmlabs.sdechallenge.MovingAverageImpl is the implementation class for MovingAverage. This implementation is for the type Double.

The constructor tells the program that what would be the value for ’N’. This is initialized in the drivers class - CalculateMovingAverage.java.

This class provides the definitions for all the 3 functions defined in the interface.These are as follows :
1. addElement() - This checks if the number to be added is not null, it will insert this number in the list. Also, it keeps on calculating the sum of last N digits by subtracting the first element in the window of N size and then adding the new number that has been inserted.
2. getElements() - returns the list of all the elements that have been added
3. calculateMovingAverage() - if the size of the list is greater than or equal to ’N’, we divide the sum by N to get the average. Otherwise, if the size of the list is less than N or N is not greater than zero, we return null.

**2. Design Question**

**Solution**

The solution design is explained in the pdf file - PaytmlabsSDEChallenge_DesignSolution.pdf

Additionally:
1. Handle large write volume: Billions of write events per day.


    Microservices based architecture will be an ideal candidate for a problem of this scale. We can have below mentioned microservices (each of which has multiple instances based on volume)
    - analytics-read : This microservice will accept data from input, do some basic validations, and post it to a Kafka topic.
    - analytics-process : This microservice listens to the Kafka topic where the analystic-read microservice publishes. It will then persist
    the received data in a No-SQL database Cassandra.

2. Handle large read/query volume: 

    `Millions of merchants wish to gain insight into their business. Read/Query patterns are time-series related metrics.
    Cassandra is a highly scalable DB which can store large amounts of data. Used together with Apache Spark it will be an efficient solution.`

3. Provide metrics to customers with at most one hour delay.

   `Splunk can be used as a log ingestion solution. This will allow us to monitor the microservices, and also created custom dashboards that provide real time data of volume, trends, and status of microservice requests`

4. Run with minimum downtime.

    `- Have microservices run in multiple instances, and regions.`
    
    `-Routing policy should be used to efficiently divide traffic amongst instances, and create new instances (using Autoscaling Groups) when required`

5. Have the ability to reprocess historical data in case of bugs in the processing logic.

    `Create a datastore which persists status of each request. analytics-read microservice should update this status. Create a third microservice that reads from that data store, and re-publishes the request on to the kafka topic`
