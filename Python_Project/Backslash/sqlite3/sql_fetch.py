import sqlite3
con = sqlite3.connect('chinook.db')
cur = con.cursor()

#storing all the table names in a
a=['albums','artists','playlists','playlist_track','tracks']
d={}

#getting column names and the table names in which these columns are present in a dictionary  
for val in a:
    cur.execute("select * from {}".format(val))
    col_list=cur.description
    l1=[]
    for i in range(len(col_list)):
        l1.append(col_list[i][0])
    for col in l1:
        if col in d:
            d[col].append(val)
        else:
            d[col]=[val]


#fetching table name in which columns 'trackId' and 'playlistId' both are present into a list			
l1=d['TrackId']
l2=d['PlaylistId']
l3=list(set(l1)&set(l2))

playlist=[1,3,5,12]
dict_of_tracks={}
#creating a dictionary for TrackId and their corresponding 10 track ids
for i in range(len(playlist)):
    cur.execute("select * from {} where PlaylistId={}".format(l3[0],playlist[i]))
    list_c=cur.fetchall()
    for j in range(10):
        if list_c[j][0] in dict_of_tracks:
            dict_of_tracks[list_c[j][0]].append(list_c[j][1])
        else:
            dict_of_tracks[list_c[j][0]]=[list_c[j][1]]

			
#fetching table name in which columns 'trackId' and 'AlbumId' both are present into a list					
tableb=list(set(l1)&set(d['AlbumId']))

f=open('f_out_final2.txt','a')
f.write("trackId \t")
f.write("albumid \t")
f.write("name \t")
f.write("\n")

#storing TrackId,AlbumId, name in a text file
for i in range(len(dict_of_tracks)):
    for j in range(len(dict_of_tracks[playlist[i]])):
        cur.execute("select TrackId,AlbumId,Name from {} where TrackId={}".format(tableb[0],dict_of_tracks[playlist[i]][j]))
        listd=cur.fetchall()
        f.write(str(listd[0][0]) +'\t')
        f.write(str(listd[0][1]) +'\t')
        f.write(listd[0][2])
        f.write("\n")
f.close()