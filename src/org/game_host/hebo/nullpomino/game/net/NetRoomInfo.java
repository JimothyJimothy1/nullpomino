/*
    Copyright (c) 2010, NullNoname
    All rights reserved.

    Redistribution and use in source and binary forms, with or without
    modification, are permitted provided that the following conditions are met:

        * Redistributions of source code must retain the above copyright
          notice, this list of conditions and the following disclaimer.
        * Redistributions in binary form must reproduce the above copyright
          notice, this list of conditions and the following disclaimer in the
          documentation and/or other materials provided with the distribution.
        * Neither the name of NullNoname nor the names of its
          contributors may be used to endorse or promote products derived from
          this software without specific prior written permission.

    THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
    AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
    IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
    ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
    LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
    CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
    SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
    INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
    CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
    ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
    POSSIBILITY OF SUCH DAMAGE.
*/
package org.game_host.hebo.nullpomino.game.net;

import java.io.Serializable;
import java.util.LinkedList;

import org.game_host.hebo.nullpomino.game.component.RuleOptions;

/**
 * ルーム情報
 */
public class NetRoomInfo implements Serializable {
	/** シリアルバージョン */
	private static final long serialVersionUID = 1L;

	/** 識別番号 */
	public int roomID = -1;

	/** ルーム名 */
	public String strName = "";

	/** 参加可能な最大人数 */
	public int maxPlayers = 6;

	/** 自動開始までの待機時間 */
	public int autoStartSeconds = 0;

	/** 落下速度(分子) */
	public int gravity = 1;

	/** 落下速度(分母) */
	public int denominator = 60;

	/** ARE */
	public int are = 30;

	/** ライン消去後ARE */
	public int areLine = 30;

	/** ライン消去時間 */
	public int lineDelay = 40;

	/** 固定時間 */
	public int lockDelay = 30;

	/** DAS */
	public int das = 14;

	/** T-Spin有効フラグ(0=なし 1=普通 2=全スピン) */
	public int tspinEnableType = 1;

	/** B2B有効 */
	public boolean b2b = true;

	/** コンボ有効 */
	public boolean combo = true;

	/** ルール固定フラグ */
	public boolean ruleLock = false;

	/** ルール名 */
	public String ruleName = "";

	/** ルール */
	public RuleOptions ruleOpt = null;

	/** 参加しているプレイヤーの数 */
	public int playerSeatedCount = 0;

	/** 観戦中の人の数 */
	public int spectatorCount = 0;

	/** ルームにいる人全員のカウント(参戦中+観戦中) */
	public int playerListCount = 0;

	/** ゲーム中フラグ */
	public boolean playing = false;

	/** ゲーム開始直後のプレイヤー数 */
	public int startPlayers = 0;

	/** 死亡カウント */
	public int deadCount = 0;

	/** 自動スタートタイマーが動いているときはtrue */
	public boolean autoStartActive = false;

	/** 誰かOK表示を出したあとキャンセルしたらtrue */
	public boolean isSomeoneCancelled = false;

	/** 3人以上生きている場合に攻撃力を減らす */
	public boolean reduceLineSend = false;

	/** Hurryup開始までの秒数(-1でHurryupなし) */
	public int hurryupSeconds = -1;

	/** Hurryup後に何回ブロックを置くたびに床をせり上げるか */
	public int hurryupInterval = 5;

	/** 自動スタートタイマーの種類(false=NullpoMino true=TNET2) */
	public boolean autoStartTNET2 = false;

	/** 誰かOK表示を出したあとキャンセルしたらタイマー無効化 */
	public boolean disableTimerAfterSomeoneCancelled = false;

	/** マップ有効 */
	public boolean useMap = false;

	/** マップをすべて受信したらtrue */
	public boolean mapReceived = false;

	/** 前回のマップ */
	public int mapPrevious = -1;

	/** 新しい断片的邪魔ブロックシステムを使う */
	public boolean useFractionalGarbage = false;

	/** マップリスト */
	public LinkedList<String> mapList = new LinkedList<String>();

	/** ルームにいる人のリスト */
	public LinkedList<NetPlayerInfo> playerList = new LinkedList<NetPlayerInfo>();

	/** ゲーム席 */
	public LinkedList<NetPlayerInfo> playerSeat = new LinkedList<NetPlayerInfo>();

	/** ゲーム席(ゲーム開始時にのみ更新・新しい人が入ってきたり誰かが出ていったりしても変わりません) */
	public LinkedList<NetPlayerInfo> playerSeatNowPlaying = new LinkedList<NetPlayerInfo>();

	/** 待ち行列 */
	public LinkedList<NetPlayerInfo> playerQueue = new LinkedList<NetPlayerInfo>();

	/**
	 * コンストラクタ
	 */
	public NetRoomInfo() {
	}

	/**
	 * コピーコンストラクタ
	 * @param n コピー元
	 */
	public NetRoomInfo(NetRoomInfo n) {
		copy(n);
	}

	/**
	 * Stringの配列からデータ代入するコンストラクタ
	 * @param rdata Stringの配列(String[7])
	 */
	public NetRoomInfo(String[] rdata) {
		importStringArray(rdata);
	}

	/**
	 * Stringからデータ代入するコンストラクタ
	 * @param str String
	 */
	public NetRoomInfo(String str) {
		importString(str);
	}

	/**
	 * 他のNetRoomInfoからコピー
	 * @param n コピー元
	 */
	public void copy(NetRoomInfo n) {
		roomID = n.roomID;
		strName = n.strName;
		maxPlayers = n.maxPlayers;
		autoStartSeconds = n.autoStartSeconds;
		gravity = n.gravity;
		denominator = n.denominator;
		are = n.are;
		areLine = n.areLine;
		lineDelay = n.lineDelay;
		lockDelay = n.lockDelay;
		das = n.das;
		tspinEnableType = n.tspinEnableType;
		b2b = n.b2b;
		combo = n.combo;

		ruleLock = n.ruleLock;
		ruleName = n.ruleName;
		if(n.ruleOpt != null) {
			ruleOpt = new RuleOptions(n.ruleOpt);
		} else {
			ruleOpt = null;
		}

		playerSeatedCount = n.playerSeatedCount;
		spectatorCount = n.spectatorCount;
		playerListCount = n.playerListCount;
		playing = n.playing;
		startPlayers = n.startPlayers;
		deadCount = n.deadCount;
		autoStartActive = n.autoStartActive;
		isSomeoneCancelled = n.isSomeoneCancelled;
		reduceLineSend = n.reduceLineSend;
		hurryupSeconds = n.hurryupSeconds;
		hurryupInterval = n.hurryupInterval;
		autoStartTNET2 = n.autoStartTNET2;
		disableTimerAfterSomeoneCancelled = n.disableTimerAfterSomeoneCancelled;
		useMap = n.useMap;
		mapReceived = n.mapReceived;
		mapPrevious = n.mapPrevious;
		useFractionalGarbage = n.useFractionalGarbage;

		mapList.clear();
		mapList.addAll(n.mapList);
		playerList.clear();
		playerList.addAll(n.playerList);
		playerSeat.clear();
		playerSeat.addAll(n.playerSeat);
		playerSeatNowPlaying.clear();
		playerSeatNowPlaying.addAll(n.playerSeatNowPlaying);
		playerQueue.clear();
		playerQueue.addAll(n.playerQueue);
	}

	/**
	 * Stringの配列からデータ代入(プレイヤーリスト除く)
	 * @param rdata Stringの配列(String[27])
	 */
	public void importStringArray(String[] rdata) {
		roomID = Integer.parseInt(rdata[0]);
		strName = NetUtil.urlDecode(rdata[1]);
		maxPlayers = Integer.parseInt(rdata[2]);
		playerSeatedCount = Integer.parseInt(rdata[3]);
		spectatorCount = Integer.parseInt(rdata[4]);
		playerListCount = Integer.parseInt(rdata[5]);
		playing = Boolean.parseBoolean(rdata[6]);
		ruleLock = Boolean.parseBoolean(rdata[7]);
		ruleName = NetUtil.urlDecode(rdata[8]);
		autoStartSeconds = Integer.parseInt(rdata[9]);
		gravity = Integer.parseInt(rdata[10]);
		denominator = Integer.parseInt(rdata[11]);
		are = Integer.parseInt(rdata[12]);
		areLine = Integer.parseInt(rdata[13]);
		lineDelay = Integer.parseInt(rdata[14]);
		lockDelay = Integer.parseInt(rdata[15]);
		das = Integer.parseInt(rdata[16]);
		tspinEnableType = Integer.parseInt(rdata[17]);
		b2b = Boolean.parseBoolean(rdata[18]);
		combo = Boolean.parseBoolean(rdata[19]);
		reduceLineSend = Boolean.parseBoolean(rdata[20]);
		hurryupSeconds = Integer.parseInt(rdata[21]);
		hurryupInterval = Integer.parseInt(rdata[22]);
		autoStartTNET2 = Boolean.parseBoolean(rdata[23]);
		disableTimerAfterSomeoneCancelled = Boolean.parseBoolean(rdata[24]);
		useMap = Boolean.parseBoolean(rdata[25]);
		useFractionalGarbage = Boolean.parseBoolean(rdata[26]);
	}

	/**
	 * String(;で区切り)からデータ代入(プレイヤーリスト除く)
	 * @param str String
	 */
	public void importString(String str) {
		importStringArray(str.split(";"));
	}

	/**
	 * Stringの配列に変換(プレイヤーリスト除く)
	 * @return Stringの配列(String[27])
	 */
	public String[] exportStringArray() {
		String[] rdata = new String[27];
		rdata[0] = Integer.toString(roomID);
		rdata[1] = NetUtil.urlEncode(strName);
		rdata[2] = Integer.toString(maxPlayers);
		rdata[3] = Integer.toString(playerSeatedCount);
		rdata[4] = Integer.toString(spectatorCount);
		rdata[5] = Integer.toString(playerListCount);
		rdata[6] = Boolean.toString(playing);
		rdata[7] = Boolean.toString(ruleLock);
		rdata[8] = NetUtil.urlEncode(ruleName);
		rdata[9] = Integer.toString(autoStartSeconds);
		rdata[10] = Integer.toString(gravity);
		rdata[11] = Integer.toString(denominator);
		rdata[12] = Integer.toString(are);
		rdata[13] = Integer.toString(areLine);
		rdata[14] = Integer.toString(lineDelay);
		rdata[15] = Integer.toString(lockDelay);
		rdata[16] = Integer.toString(das);
		rdata[17] = Integer.toString(tspinEnableType);
		rdata[18] = Boolean.toString(b2b);
		rdata[19] = Boolean.toString(combo);
		rdata[20] = Boolean.toString(reduceLineSend);
		rdata[21] = Integer.toString(hurryupSeconds);
		rdata[22] = Integer.toString(hurryupInterval);
		rdata[23] = Boolean.toString(autoStartTNET2);
		rdata[24] = Boolean.toString(disableTimerAfterSomeoneCancelled);
		rdata[25] = Boolean.toString(useMap);
		rdata[26] = Boolean.toString(useFractionalGarbage);
		return rdata;
	}

	/**
	 * Stringに変換(;で区切り)(プレイヤーリスト除く)
	 * @return String
	 */
	public String exportString() {
		String[] data = exportStringArray();
		String strResult = "";

		for(int i = 0; i < data.length; i++) {
			strResult += data[i];
			if(i < data.length - 1) strResult += ";";
		}

		return strResult;
	}

	/**
	 * プレイヤー数カウントを更新
	 */
	public void updatePlayerCount() {
		playerSeatedCount = getNumberOfPlayerSeated();
		playerListCount = playerList.size();
		spectatorCount = playerListCount - playerSeatedCount;
	}

	/**
	 * 今ゲーム席にいる人の数を数える(null席はカウントしない)
	 * @return 今ゲーム席にいる人の数
	 */
	public int getNumberOfPlayerSeated() {
		int count = 0;
		for(int i = 0; i < playerSeat.size(); i++) {
			if(playerSeat.get(i) != null) count++;
		}
		return count;
	}

	/**
	 * 指定したプレイヤーがゲーム席にいるかどうか調べる
	 * @param pInfo プレイヤー
	 * @return 指定したプレイヤーがゲーム席にいるならtrue
	 */
	public boolean isPlayerInSeat(NetPlayerInfo pInfo) {
		return playerSeat.contains(pInfo);
	}

	/**
	 * 指定したプレイヤーがどの番号のゲーム席にいるか調べる
	 * @param pInfo プレイヤー
	 * @return ゲーム席番号(いないなら-1)
	 */
	public int getPlayerSeatNumber(NetPlayerInfo pInfo) {
		for(int i = 0; i < playerSeat.size(); i++) {
			if(playerSeat.get(i) == pInfo) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * @return 順番待ちなしですぐにゲーム席に入れるならtrue
	 */
	public boolean canJoinSeat() {
		return (getNumberOfPlayerSeated() < maxPlayers);
	}

	/**
	 * ゲーム席に入る
	 * @param pInfo プレイヤー
	 * @return ゲーム席の番号(満員だったら-1)
	 */
	public int joinSeat(NetPlayerInfo pInfo) {
		if(canJoinSeat()) {
			exitQueue(pInfo);

			for(int i = 0; i < playerSeat.size(); i++) {
				if(playerSeat.get(i) == null) {
					playerSeat.set(i, pInfo);
					return i;
				}
			}

			playerSeat.add(pInfo);
			return playerSeat.size() - 1;
		}
		return -1;
	}

	/**
	 * 指定したプレイヤーをゲーム席から外す
	 * @param pInfo プレイヤー
	 */
	public void exitSeat(NetPlayerInfo pInfo) {
		for(int i = 0; i < playerSeat.size(); i++) {
			if(playerSeat.get(i) == pInfo) {
				playerSeat.set(i, null);
			}
		}
	}

	/**
	 * 順番待ちに入る
	 * @param pInfo プレイヤー
	 * @return 順番待ち番号
	 */
	public int joinQueue(NetPlayerInfo pInfo) {
		if(playerQueue.contains(pInfo)) {
			return playerQueue.indexOf(pInfo);
		}
		playerQueue.add(pInfo);
		return playerQueue.size() - 1;
	}

	/**
	 * 指定したプレイヤーを順番待ちから外す
	 * @param pInfo プレイヤー
	 */
	public void exitQueue(NetPlayerInfo pInfo) {
		playerQueue.remove(pInfo);
	}

	/**
	 * 何人のプレイヤーが準備完了したか数える
	 * @return 準備完了したプレイヤーの数
	 */
	public int getHowManyPlayersReady() {
		int count = 0;
		for(NetPlayerInfo pInfo: playerSeat) {
			if(pInfo != null) {
				if(pInfo.ready) count++;
			}
		}
		return count;
	}

	/**
	 * 何人のプレイヤーがプレイ中か数える(死んだ人とまだ部屋に来た直後の人は含みません)
	 * @return プレイ中のプレイヤーの数
	 */
	public int getHowManyPlayersPlaying() {
		int count = 0;
		for(NetPlayerInfo pInfo: playerSeatNowPlaying) {
			if(pInfo != null) {
				if(pInfo.playing) count++;
			}
		}
		return count;
	}

	/**
	 * 最後に生き残ったプレイヤーの情報を取得
	 * @return 最後に生き残ったプレイヤーの情報(まだ2人以上生きている場合や、そもそもゲームが始まっていない場合はnull)
	 */
	public NetPlayerInfo getWinner() {
		if((startPlayers >= 2) && (getHowManyPlayersPlaying() < 2) && (playing == true)) {
			for(NetPlayerInfo pInfo: playerSeatNowPlaying) {
				if(pInfo != null) {
					if(pInfo.playing && pInfo.connected)
						return pInfo;
				}
			}
		}
		return null;
	}

	/**
	 * 最後に生き残ったチーム名を取得
	 * @return 最後に生き残ったチーム名
	 */
	public String getWinnerTeam() {
		if((startPlayers >= 2) && (getHowManyPlayersPlaying() >= 2) && (playing == true)) {
			for(NetPlayerInfo pInfo: playerSeatNowPlaying) {
				if((pInfo != null) && (pInfo.playing) && (pInfo.connected)) {
					if(pInfo.strTeam.length() <= 0) {
						return null;
					} else {
						return pInfo.strTeam;
					}
				}
			}
		}

		return null;
	}

	/**
	 * @return 1つのチームだけが生き残っている場合にtrue
	 */
	public boolean isTeamWin() {
		String teamname = null;

		if((startPlayers >= 2) && (getHowManyPlayersPlaying() >= 2) && (playing == true)) {
			for(NetPlayerInfo pInfo: playerSeatNowPlaying) {
				if((pInfo != null) && (pInfo.playing) && (pInfo.connected)) {
					if(pInfo.strTeam.length() <= 0) {
						return false;
					} else if(teamname == null) {
						teamname = pInfo.strTeam;
					} else if(!teamname.equalsIgnoreCase(pInfo.strTeam)) {
						return false;
					}
				}
			}
		}

		return (teamname != null);
	}

	/**
	 * ゲーム開始時に呼び出す処理
	 */
	public void gameStart() {
		updatePlayerCount();
		playerSeatNowPlaying.clear();
		playerSeatNowPlaying.addAll(playerSeat);
		startPlayers = playerSeatedCount;
		deadCount = 0;
		autoStartActive = false;
		isSomeoneCancelled = false;
	}

	/**
	 * ルーム消去時の処理
	 */
	public void delete() {
		ruleOpt = null;
		mapList.clear();
		playerList.clear();
		playerSeat.clear();
		playerSeatNowPlaying.clear();
		playerQueue.clear();
	}
}