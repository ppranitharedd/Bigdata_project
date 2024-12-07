# Bigdata_project

# Sentiment Analysis on Product Reviews

## Team Name
**Product Pulse**

## Team Members
- Pranitha Reddy Policepatel
- Rakshitha Boddireddy
- Varshitha Lavu

## Project Title
**Sentiment Analysis on Product Reviews**

## Project Idea
This project aims to analyze customer sentiment in Amazon product reviews to uncover insights into customer satisfaction across various product categories. By leveraging sentiment analysis techniques, the project will:
- Tokenize customer reviews to identify sentiment (positive, neutral, negative).
- Extract words and phrases associated with specific sentiments.
- Compute sentiment distributions and average sentiment scores for each product category.
- Present findings through data visualizations to highlight trends, key phrases, and satisfaction levels.

## Technology Summary
The following tools and technologies were used:
- **Programming Language**: Java (for MapReduce implementation).
- **Framework**: Hadoop (for distributed processing).
- **Visualization Tool**: Tableau (for sentiment visualization and reporting).
- **Database**: HDFS (for storing and managing the dataset).
- **Libraries**: Natural Language Toolkit (NLTK) or TextBlob for sentiment scoring.

## Architecture Summary
1. **Input**: Raw dataset of Amazon product reviews uploaded to HDFS.
2. **Mapper**: Reads each review, tokenizes text into words, assigns sentiment scores, and maps reviews to product categories.
3. **Reducer**: Aggregates sentiment scores, calculates average sentiment distributions, and summarizes results by category.
4. **Output Storage**: Processes and stores sentiment analysis results in HDFS.
5. **Visualization**: Tableau retrieves and visualizes the data through interactive dashboards.

## Implementation Steps
1. **Data Collection and Preparation**:
   - Obtain and preprocess the dataset (e.g., remove noise, tokenize text).
   - Upload data into HDFS for efficient distributed processing.
2. **Mapper and Reducer Implementation**:
   - Develop MapReduce programs in Java to process and aggregate sentiment data.
3. **Data Storage**:
   - Store processed results in HDFS.
4. **Visualization**:
   - Use Tableau to design dashboards for sentiment trends, word clouds, and satisfaction rankings.
5. **Insights and Recommendations**:
   - Analyze visualized data to identify patterns and actionable insights for product improvement.

## Results Summary
- The program classifies sentiment as Positive, Neutral, or Negative.
- Visualizations highlight trends, key phrases, and satisfaction levels for product categories.
- Businesses gain insights into customer feedback to improve products and services.

## Dataset
The dataset used for this project can be accessed at:  
[Amazon Product Reviews Dataset](https://www.kaggle.com/datasets/saurav9786/amazon-product-reviews)

## References
1. Product Sentiment Analysis for Amazon Reviews:  
   [https://journalofbigdata.springeropen.com/articles/10.1186](https://journalofbigdata.springeropen.com/articles/10.1186)
2. Sentiment Analysis Using Product Review Data:  
   [https://cs229.stanford.edu/proj2018/report/122.pdf](https://cs229.stanford.edu/proj2018/report/122.pdf)
3. Sentiment Analysis of Product Reviews:  
   [https://ieeexplore.ieee.org/document/8862258](https://ieeexplore.ieee.org/document/8862258)

## GitHub
The GitHub repository for this project can be accessed at:  
[https://github.com/ppranitharedd/Bigdata_project.git](https://github.com/ppranitharedd/Bigdata_project.git)

