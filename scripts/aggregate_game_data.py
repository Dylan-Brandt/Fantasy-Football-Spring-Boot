### File to aggregate individual game data to the entire season for each player

import csv

season_data = {}

# save only useful rows
rows_to_save = ["pass_cmp","pass_att","pass_yds","pass_td","pass_int","rush_att","rush_yds","rush_td","targets","rec","rec_yds","rec_td","fumbles_lost","two_point_conv","total_ret_td","offensive_fumble_recovery_td"]

with open('../data/nfl_pass_rush_receive_raw_data.csv') as file:
    game_data = csv.DictReader(file)
    for row in game_data:
        if row['player_id'] not in season_data.keys():
            season_data[row['player_id']] = {}
            season_data[row['player_id']]['pos'] = row['pos']
            season_data[row['player_id']]['player'] = row['player']
        season_data[row['player_id']]['team'] = row['team']
        for k, v in row.items():
            if k in rows_to_save:
                #add the row data to the player's total
                season_data[row['player_id']][k] = season_data.get(row['player_id'], {}).get(k, 0) + int(v)

# calculate passer ratings
for player in season_data.keys():
    attempts = season_data[player]['pass_att']
    if attempts > 0:
        completions = season_data[player]['pass_cmp']
        yards = season_data[player]['pass_yds']
        interceptions = season_data[player]['pass_int']
        touchdowns = season_data[player]['pass_td']
        #formula for passer rating - https://en.wikipedia.org/wiki/Passer_rating
        a = (completions/attempts - 0.3) * 5
        b = (yards/attempts - 3) * 0.25
        c = (touchdowns/attempts) * 20
        d = 2.375 - (interceptions/attempts * 25)
        pass_rating = ((a + b + c + d) / 6) * 100
        season_data[player]['pass_rating'] = round(pass_rating, 2)
    if 'pass_rating' not in season_data[player]:
        season_data[player]['pass_rating'] = 0.0
        
# column names
col_names = ['player_id', 'pos', 'player', 'team']
col_names.extend(rows_to_save)
col_names.append('pass_rating')

# write aggregate season data to file
with open('../data/2022_season_data.csv', 'w') as output:
    output.write(','.join(col_names))
    for key, val in sorted(season_data.items()):
        row = {'player_id': key}
        row.update(val)
        output.write('\n' + ','.join((str(x) for x in row.values())))


    

        
            
