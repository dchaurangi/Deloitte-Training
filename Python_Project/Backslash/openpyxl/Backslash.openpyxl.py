#!/usr/bin/env python
# coding: utf-8

# In[38]:


#importing load_workbook and Workbook from openpyxl
from openpyxl import load_workbook
from openpyxl import Workbook

#importing the formatting libraries
from openpyxl.styles import Fill,Font,Color,colors

#generating the new excel file
wb3 = Workbook()
wb3.save(filename = 'excel_file_diff.xlsx')
#set file path for the three excel files
filepath1="excel_file_old.xlsx"
filepath2="excel_file_new.xlsx"
filepath3="excel_file_diff.xlsx"

#loading all the excel files
wb1=load_workbook(filepath1)
wb2=load_workbook(filepath2)

#selecting the three excel sheets
sheet1=wb1.active
sheet2=wb2.active
sheet3=wb3.active

#evaluating the maximum rows and columns
max_row1=sheet1.max_row
max_column1=sheet1.max_column

#printing the header of the excel file
for i in range(1,2):
     for j in range(1,max_column1+1):
        cell_obj1=sheet1.cell(row=i,column=j)
        sheet3.cell(row=i, column=j).value = cell_obj1.value
wb3.save(filepath3)

"""comparing cell by cell from the two excel sheets 
#and printing the strings as it is and the differences of the values in the 3rd sheet"""
for i in range(2,max_row1+1):
     for j in range(1,max_column1+1):
        cell_obj1=sheet1.cell(row=i,column=j) 
        cell_obj2=sheet2.cell(row=i,column=j)
        if type(cell_obj1.value) == str and type(cell_obj2.value) == str  :
            sheet3.cell(row=i, column=j).value = cell_obj1.value
        else:
            temp=cell_obj1.value-cell_obj2.value
            sheet3.cell(row=i, column=j).value = temp
            if temp!=0:
                sheet3.cell(row=i, column=j).font = Font(color=colors.RED) #formatting here
wb3.save(filepath3)
            






