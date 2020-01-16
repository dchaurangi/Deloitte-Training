#!/usr/bin/env python
# coding: utf-8

# In[1]:


import pandas as pd

def color_negative_red(val):
    """
    Takes a scalar and returns a string with
    the css property `'color: red'` for negative
    strings, black otherwise.
    """
    color = 'red' if (val != 0  and type(val) !=str) else 'black'
    return 'color: %s' % color

#importing excel to DataFrame
df1=pd.read_excel('excel_file_old.xlsx') #Df1 will represent the old file
df2=pd.read_excel('excel_file_new.xlsx') #Df2 will represent the new file

comparison_values = df1.values == df2.values #comparison values will check boolean values

df3=df1.copy()

import numpy as np #importing numpy to compare on a micro level for rows and columns

#for comparing rows and columns where values are not same i.e False
rows,cols=np.where(comparison_values==False) 
for item in zip(rows,cols):
    df3.iloc[item[0],item[1]]=df1.iloc[item[0],item[1]]-df2.iloc[item[0],item[1]]
    
#for comparing rows and columns where values are same i.e True
rows,cols=np.where(comparison_values==True)
for item in zip(rows,cols):
    if (type(df1.iloc[item[0],item[1]])!= str):
        df3.iloc[item[0],item[1]]=df1.iloc[item[0],item[1]]-df2.iloc[item[0],item[1]]
        

#formatting the final output, changing font to red for updated values
s = df3.style.applymap(color_negative_red)

#file export to new file
s.to_excel('./Excel_diff.xlsx',index=False,header=True)


# In[ ]:




